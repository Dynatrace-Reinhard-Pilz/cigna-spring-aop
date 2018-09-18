package dynatrace;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Driver {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Driver.class);
	
	private Session session = new Session();

	public Session session() {
		LOGGER.info("session");
		return session;
	}
}
