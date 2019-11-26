package org.app.domain.services;

import java.util.logging.Logger;

import org.app.domain.AggregateView;
import org.app.domain.RootEntity;
import org.springframework.stereotype.Service;

/*
 * Naming template: Action.ing Entity-name Service-type
 */
@Service
public class ConsolidatingAggregateServiceImpl implements IConsolidatingAggregateService {
	private static Logger logger = Logger.getLogger(ConsolidatingAggregateServiceImpl.class.getName());
	//
	
	@Override
	public AggregateView countingComponents(RootEntity rootEntity) {
		logger.info(">>> Service: ConsolidatingAggregateServiceImpl :: countingComponents.");
		//
		Integer componentsCount = (rootEntity.getComponents() == null) ? 0 : rootEntity.getComponents().size();
		return new AggregateView(rootEntity.getRootId(), componentsCount);
	}
}
