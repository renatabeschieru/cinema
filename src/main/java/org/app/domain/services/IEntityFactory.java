package org.app.domain.services;

import java.util.Date;

import org.app.domain.RootEntity;

public interface IEntityFactory {

	public RootEntity buildAggregate(String name, Date startDate);
	
	public void initDomainServiceEntities() ;
}
