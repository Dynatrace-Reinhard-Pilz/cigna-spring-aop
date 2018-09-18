package dynatrace;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ContextDefinitionGraphServiceImpl implements ContextDefinitionGraphService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ContextDefinitionGraphServiceImpl.class);

	@Override
	@Transactional
	public void saveSourceContext(ContextDefinition sourceContext) {
		LOGGER.info("saveSourceContext");
		Thread.dumpStack();
	}

}
