package org.app.spring;

import java.util.logging.Logger;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.aopalliance.intercept.MethodInterceptor;
import org.app.domain.services.AuditingBusinessWorkflowServiceImpl;
import org.app.domain.services.IAuditingBusinessWorkflowService;
import org.app.domain.services.IBusinessWorkflowService;
import org.app.domain.services.IEntityFactory;
import org.app.domain.services.IEntityRepository;
import org.app.domain.services.EntityFactoryBase;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Configuration
@ComponentScan(basePackages = {"org.app.domain.services"})
public class AppScanConfig {
	private static Logger logger = Logger.getLogger(AppScanConfig.class.getName());
	
	@Bean 
	public LocalValidatorFactoryBean validator() {
		return new LocalValidatorFactoryBean();
	}
	
	@Autowired @Qualifier("EntityFactoryBase")
	private IEntityFactory entityFactory;
	
	// Auditing
	@Autowired @Qualifier("BusinessWorkflowServiceImpl")
	private IBusinessWorkflowService planningProjectBusinessWorkflowService;
	
	@Autowired
	private IAuditingBusinessWorkflowService auditService;
	
	@Bean(name="proxyAuditedService")
	public IBusinessWorkflowService entityFactory() {
		logger.info(">>> Service: AppScanConfig :: entityFactory.");
		
		ProxyFactory pf = new ProxyFactory();
		pf.addAdvice((MethodInterceptor)auditService);
		pf.setTarget(planningProjectBusinessWorkflowService);
		IBusinessWorkflowService proxyAuditedService = (IBusinessWorkflowService) pf.getProxy();
		
		return proxyAuditedService;
	}
}
