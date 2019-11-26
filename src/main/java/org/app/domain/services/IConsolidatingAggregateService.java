package org.app.domain.services;

import org.app.domain.AggregateView;
import org.app.domain.RootEntity;

public interface IConsolidatingAggregateService {

	AggregateView countingComponents(RootEntity project);
	
}