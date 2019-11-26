package org.app.domain.services;

import org.app.domain.RootEntity;

public interface ISummarizingAggregateService {

	RootEntity countingComponents(RootEntity project);
	
}