package org.app.domain.services;

import org.app.domain.RootEntity;
import org.springframework.context.ApplicationEvent;

public class DomainEvent extends ApplicationEvent{
	private static final long serialVersionUID = 1L;
	//
	private RootEntity message;
	
	public DomainEvent(Object source) {
		super(source);
	}

	public DomainEvent(Object source, RootEntity message) {
		super(source);
		this.message = message;
	}
	
	public RootEntity getMessage() {
		return message;
	}
}

// https://www.baeldung.com/spring-events