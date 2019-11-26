package org.app.domain.services;

import java.util.logging.Logger;

import org.app.domain.RootEntity;
import org.springframework.stereotype.Service;

/*
 * Naming template: Action.ing Entity-name Service-type
 */
@Service
public class SummarizingAggregateServiceImpl implements ISummarizingAggregateService {
	private static Logger logger = Logger.getLogger(SummarizingAggregateServiceImpl.class.getName());
	//
	@Override
	public RootEntity countingComponents(RootEntity rootEntity) {
		logger.info(">>> Service: SummarizingAggregateServiceImpl :: countingComponents.");
		Integer componentsCount = (rootEntity.getComponents() == null) ? 0 : rootEntity.getComponents().size();
		rootEntity.setComponentsCount(componentsCount);
		return rootEntity;
	}
}
