package dynatrace;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Controller {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Controller.class);
	
	@Autowired
	private ContextDefinitionGraphService service;

    public void execute() {
    	LOGGER.info("execute");
    	service.saveSourceContext(new ContextDefinition());
    }

}