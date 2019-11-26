package org.app.domain.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.app.domain.RootEntity;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//SDI Bean Component 
@Component @Scope("singleton")
public class EntityRepositoryBase implements IEntityRepository{
	
	private static Logger logger = Logger.getLogger(EntityRepositoryBase.class.getName());
	
	public EntityRepositoryBase() {
		logger.info(">>> BEAN: EntityRepositoryBase instantiated!");
	}
	//
	private Map<Integer, RootEntity> entities = new HashMap<>();
	// 
	private Integer nextID = 0;
	@Override
	public Integer getNextID() {
		nextID++;
		return nextID;
	}
	
	@Override
	public RootEntity getById(Integer id) {
		logger.info(">>> Service: EntityRepositoryBase :: getById.");
		
		return entities.get(id);
	}

	@Override
	public RootEntity get(RootEntity sample) {
		return getById(sample.getRootId());
	}	
	
	@Override
	public Collection<RootEntity> toCollection() {
		List<RootEntity> projectList = new ArrayList<>();
		projectList.addAll(this.entities.values());
		return projectList;
	}

	@Override
	public RootEntity add(RootEntity entity) {
		logger.info(">>> Service: EntityRepositoryBase :: add.");
		
		
		if (entity.getRootId() == null) {
			nextID++;
			entity.setRootId(nextID);
		}
		entities.put(entity.getRootId(), entity);
		return entity;
	}

	@Override
	public Collection<RootEntity> addAll(Collection<RootEntity> entities) {
		for(RootEntity entity: entities)
			this.add(entity);
		return entities;
	}

	@Override
	public boolean remove(RootEntity entity) {
		if (this.entities.containsValue(entity)) {
			this.entities.remove(entity.getRootId());
			return true;
		}
		return false;
	}

	@Override
	public boolean removeAll(Collection<RootEntity> entities) {
		Boolean flag =  true;
		for(RootEntity entity: entities) {
			if (!this.remove(entity))
				flag = false;
		}
		
		return flag;
	}

	@Override
	public int size() {
		return this.entities.values().size();
	}

}
