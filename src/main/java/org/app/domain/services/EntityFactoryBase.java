package org.app.domain.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;

import org.app.domain.ComponentEntity;
import org.app.domain.RootEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("EntityFactoryBase")
@Scope("singleton")
public class EntityFactoryBase implements IEntityFactory {
	private static Logger logger = Logger.getLogger(EntityFactoryBase.class.getName());
	
	@Autowired
	private IEntityRepository entityRepository;
	
	public EntityFactoryBase() {
		logger.info(">>> BEAN: EntityFactoryBase instantiated!");
	}
	
	@Override
	public RootEntity buildAggregate(String name, Date startDate) {
		logger.info(">>> Service: EntityFactoryBase :: buildAggregate.");
		//
		RootEntity rootEntity = new RootEntity(1, name, startDate);
		List<ComponentEntity> components = new ArrayList<>();
		ComponentEntity component = new ComponentEntity(1, "R: " + rootEntity.getRootName() + "." + 1, rootEntity);
		components.add(component);
		rootEntity.setComponents(components);
		return rootEntity;
	}
	
	@PostConstruct
	@Override
	public void initDomainServiceEntities() {
		logger.info(">> PostConstruct :: initDomainServiceEntities");
		for(int i=1; i<=3; i++) {
			RootEntity newEntity = buildAggregate("Project_" + i, new Date());
			entityRepository.add(newEntity);
		}
		logger.info(">> EntityRepository entity.count :: " + entityRepository.size());
	}
}
