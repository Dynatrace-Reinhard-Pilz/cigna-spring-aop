package dynatrace;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class DBContext {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DBContext.class);

	public void init() {
		LOGGER.info("init");
	}

	public void rollbackTransaction() {
		LOGGER.info("rollbackTransaction");
	}

	public void destroy() {
		LOGGER.info("destroy");
	}
	
}
