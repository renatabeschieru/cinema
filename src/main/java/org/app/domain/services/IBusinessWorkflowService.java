package org.app.domain.services;

import java.util.Date;

import org.app.domain.AggregateView;

/*
 * Business Workflow Steps/Actions:
 * (1) ...
 * (2) ...
 * (3) ...
 */
public interface IBusinessWorkflowService {

	// (1) Start workflow
	Integer startWorkflow(String rootName, Date startDate);

	// (2) Update Aggregate
	Integer updateAggregate(Integer rootId);

	// (3) Get Aggregate summary data
	AggregateView getAggregateSummaryData(Integer rootId);

}