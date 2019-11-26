package org.app.domain.services;

import java.util.logging.Logger;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Service;

@Service
// Auditing IBusinessWorkflowService
public class AuditingBusinessWorkflowServiceImpl implements 
		IAuditingBusinessWorkflowService, 
		MethodInterceptor{
	private static Logger logger = Logger.getLogger(AuditingBusinessWorkflowServiceImpl.class.getName());
	
	// Business Logic
	@Override
	public void audit(Integer rootId, String rootName) {
		logger.info(">>> Service: AuditingBusinessWorkflowServiceImpl :: audit.");

		// Audit business logic
		logger.info("AUDIT INFO: " + rootId + " : " + rootName);
	}

	// AOP Invocation Logic
	@Override
	public Object invoke(MethodInvocation ic) throws Throwable {
		logger.info(">>>> SpringAOP.INTERCEPTION: Entering in Interceptor for: " 
					+ ic.getMethod().getName()
					+ ", " + ic.getStaticPart().getClass() 
					+ ", " + ic.getThis().getClass());
		try {
			if (ic.getMethod().getName().equals("startWorkflow")) {
				String rootName = (String) ic.getArguments()[0];
				// invoke target
				Integer rootId = (Integer) ic.proceed();
				audit(rootId, rootName);
				return rootId;
			}
			// invoke target
			return ic.proceed();
		} finally {
			logger.info(">>>> SpringAOP.INTERCEPTION: Exiting in Interceptor for: " + ic.getMethod().getName());
		}
		
	}
}
