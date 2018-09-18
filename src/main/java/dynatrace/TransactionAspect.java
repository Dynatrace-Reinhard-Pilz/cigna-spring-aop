package dynatrace;

import java.lang.reflect.Method;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order
@Component
public class TransactionAspect {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TransactionAspect.class);
	
	@Autowired
	private Driver driver;
	
	@Autowired
	private CgnTransactionManager transactionManager;
	
	@Autowired
	private DBContext dbContext;
	
	@Around("@annotation(dynatrace.Transactional)")
	public Object manageTransaction(ProceedingJoinPoint joinPoint) throws Throwable {
		LOGGER.info("manageTransaction");
		Transaction transactionWithoutException = transactionManager.getTransactionWithoutException();
		
		if (transactionWithoutException != null) {
			return joinPoint.proceed();
		} else {
			LOGGER.info("No transaction found, creating the new one");
		}
		
		final TransactionWork<Object> transactionWork = (Transaction transaction) -> {
			transactionManager.init(transaction);
			try {
				return joinPoint.proceed();
			} catch (Throwable throwable) {
				if (throwable instanceof RuntimeException) {
					throw (RuntimeException) throwable;
				} else {
					throw new RuntimeException("Exception in method annotated with transactional annotation", throwable);
				}
			} finally {
				transactionManager.destroy();
			}
		};
		
		Transactional transactional = getTransactionalAnnotation(joinPoint);
		if (transactional.enableMongoTransaction()) {
			dbContext.init();
		}
		
		try (Session session = driver.session()) {
			if (transactional.readOnly()) {
				return session.readTransaction(transactionWork);
			} else {
				return session.writeTransaction(transactionWork);
			}
		} catch (Exception ex) {
			dbContext.rollbackTransaction();
			throw ex;
		} finally {
			dbContext.destroy();
		}
	}

	private Transactional getTransactionalAnnotation(ProceedingJoinPoint joinPoint) {
		LOGGER.info("getTransactionalAnnotation");
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		Method method = signature.getMethod();
		return method.getAnnotation(Transactional.class);
	}

}
