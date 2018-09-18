package dynatrace;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class CgnTransactionManager {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CgnTransactionManager.class);
	
	private static final ThreadLocal<Transaction> TRANSACTION = new ThreadLocal<>();
	
	public CgnTransactionManager() {
		
	}
	
	public void init(Transaction transaction) {
		LOGGER.info("init");
		TRANSACTION.set(transaction);
	}

	public Transaction getTransaction() {
		LOGGER.info("getTransaction");
		final Transaction transaction = TRANSACTION.get();
		if (transaction == null) {
			Thread.dumpStack();
			throw new TransactionException("Not found transaction in ThreadLocal."+
						"Note: Service or repository method should be annotated with @Transactional annotation.");
		}
		return transaction;
	}

	public Transaction getTransactionWithoutException() {
		LOGGER.info("getTransactionWithoutException");
		return TRANSACTION.get();
	}
	
	public void destroy() {
		LOGGER.info("destroy");
		TRANSACTION.remove();
	}
	
}
