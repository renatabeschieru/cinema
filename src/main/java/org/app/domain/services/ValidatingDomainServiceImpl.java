package org.app.domain.services;

import java.util.Set;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.app.domain.RootEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

@Service
public class ValidatingDomainServiceImpl 
	implements ApplicationListener<DomainEvent>, 
		IValidatingDomainService{
	private static Logger logger = Logger.getLogger(ValidatingDomainServiceImpl.class.getName());
	
	@Autowired
	private Validator validator;
	
	//
	@Override
	public Set<String> validate(RootEntity project){
		logger.info(">>> Service: ValidatingDomainServiceImpl :: validate.");
		
		//
		Set<ConstraintViolation<RootEntity>> violations = validator
				.validate(project);
		logger.info("Violations count: " + violations.size());
		
		
		return violations.stream()
				.map(violation -> violation.getMessage() + " (" 
							+ violation.getInvalidValue() + ") is an invalid value!" )
				.collect(Collectors.toSet()); 
	}
	
	@Override
	public void validateWithException(RootEntity project){
		Set<String> violations = validate(project);
		logger.info("Violations count (to generate exception): " + violations.size());
		
		if (violations.size() > 0) {
			String violationExceptionMessage = violations.stream()
					.map(violation -> ">>> JEE.Spring bean validator exception: " + violation)
					.collect(Collectors.joining(", "));
			try {
				validateProjectAggregate(project);
			}catch(Exception ex) {
				violationExceptionMessage += " Local validation: "
						+ ex.getMessage();
			}
			throw new RuntimeException(violationExceptionMessage);
		}
	}
	
	// Event-based Business Service Integration
	// SpringEvents:: Listening
	@Override
	public void onApplicationEvent(DomainEvent domainEvent) {
		RootEntity buildProject = domainEvent.getMessage();
		logger.info(">>>***Validating_ListeningEvents***>>> for: " + domainEvent.getMessage());
		this.validateWithException(buildProject);
	}
	
	// Local business validation method
	private boolean validateProjectAggregate(RootEntity rootEntity) {
		if (rootEntity == null)
			throw new RuntimeException("Null Project!");
		if (rootEntity.getComponents() == null || rootEntity.getComponents().size() == 0)
			throw new RuntimeException("Null Releases!");
		return true;
	}
}
