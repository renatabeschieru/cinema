package org.app.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ComponentEntity {
	@Id @GeneratedValue
	private Integer componentId;
	
	private String componentName;
	
	@ManyToOne
	private RootEntity root;

	/* -------------------------------------------- */
	public Integer getComponentId() {
		return componentId;
	}

	public void setComponentId(Integer componentId) {
		this.componentId = componentId;
	}

	public String getComponentName() {
		return componentName;
	}

	public void setComponentName(String componentName) {
		this.componentName = componentName;
	}

	public RootEntity getRoot() {
		return root;
	}

	public void setRoot(RootEntity root) {
		this.root = root;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((componentId == null) ? 0 : componentId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ComponentEntity other = (ComponentEntity) obj;
		if (componentId == null) {
			if (other.componentId != null)
				return false;
		} else if (!componentId.equals(other.componentId))
			return false;
		return true;
	}

	public ComponentEntity() {
		super();
	}

	public ComponentEntity(Integer componentId, String componentName, RootEntity root) {
		super();
		this.componentId = componentId;
		this.componentName = componentName;
		this.root = root;
	}
	
	
}
