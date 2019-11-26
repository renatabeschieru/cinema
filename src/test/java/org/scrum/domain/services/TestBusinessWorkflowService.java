package org.scrum.domain.services;

import java.util.Date;
import java.util.logging.Logger;

import org.app.domain.AggregateView;
import org.app.domain.services.IBusinessWorkflowService;
import org.app.spring.AppScanConfig;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = AppScanConfig.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestBusinessWorkflowService {
	private static Logger logger = Logger.getLogger(TestBusinessWorkflowService.class.getName());
	
	@Autowired @Qualifier("BusinessWorkflowServiceImpl") 
	private IBusinessWorkflowService businessWorkflowService;
	
	@Test
	public void test1_WorkflowService() {
		logger.info("-----------------------------------------------------------------------------");
		logger.info("Service implementation instance:: " + businessWorkflowService);
		logger.info("Service implementation class:: " + businessWorkflowService.getClass().getName());
		
		Date tomorow = new Date(new Date().getTime() + 1000*60*60*24*1);
		// 1.
		Integer rootId = businessWorkflowService.startWorkflow("Aggregate.Test", tomorow);
		// 2...
		businessWorkflowService.updateAggregate(rootId);
		// 2.
		AggregateView viewData = businessWorkflowService.getAggregateSummaryData(rootId);
		// 
		logger.info(viewData.toString());
		
	}
	
	
	@Autowired @Qualifier("proxyAuditedService")
	private IBusinessWorkflowService auditedBusinessWorkflowService;
	
	@Test
	public void test2_AuditWorkflowService() {
		logger.info("-----------------------------------------------------------------------------");
		logger.info("Service implementation instance:: " + businessWorkflowService);
		logger.info("Service implementation class:: " + businessWorkflowService.getClass().getName());
		
		Date tomorow = new Date(new Date().getTime() + 1000*60*60*24*1);
		// 1.
		Integer rootId = auditedBusinessWorkflowService.startWorkflow("Aggregate.Test", tomorow);
		// 2...
		auditedBusinessWorkflowService.updateAggregate(rootId);
		// 2.
		AggregateView viewData = auditedBusinessWorkflowService.getAggregateSummaryData(rootId);
		// 
		logger.info(viewData.toString());
	}
}
