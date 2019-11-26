package org.app.domain.services;

import java.util.Collection;

import org.app.domain.RootEntity;

public interface IEntityRepository {
	public Integer getNextID() ;
	
	//
	public RootEntity getById(Integer id);
	public RootEntity get(RootEntity sample);
	public Collection<RootEntity> toCollection(); // getAll
	
	//
	public RootEntity add(RootEntity entity);
	public Collection<RootEntity> addAll(Collection<RootEntity> entities);
	public boolean remove(RootEntity entity);
	public boolean removeAll(Collection<RootEntity> entities);	
	
	//
	public int size();
	
}
