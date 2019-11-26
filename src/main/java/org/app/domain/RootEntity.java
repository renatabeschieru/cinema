package org.app.domain;
import static javax.persistence.FetchType.EAGER;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;

@Entity
public class RootEntity implements Serializable, Comparable<RootEntity>{
	/* internal stucture: member fields*/
	@Id @GeneratedValue
	private Integer rootId;
	
	@NotNull(message = " Root Name is required!") 
	private String rootName;
	
	@Future(message = " StartDate must be a future date!")
	@Temporal(TemporalType.DATE)
	private Date startDate;
	
	@OneToMany(mappedBy="root", cascade = CascadeType.ALL, fetch = EAGER, orphanRemoval = true)
	private List<ComponentEntity> components = new ArrayList<>();
	
	protected Integer componentsCount = 0;
	
	/* Constructors */
	public RootEntity(Integer projectNo, String name, Date startDate) {
		super();
		this.rootId = projectNo;
		this.rootName = name;
		this.startDate = startDate;
	}

	public RootEntity() {
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((rootId == null) ? 0 : rootId.hashCode());
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
		RootEntity other = (RootEntity) obj;
		if (rootId == null) {
			if (other.rootId != null)
				return false;
		} else if (!rootId.equals(other.rootId))
			return false;
		return true;
	}
	public RootEntity(Integer nrProiect, String numeProiect) {
		super();
		this.rootId = nrProiect;
		this.rootName = numeProiect;
	}
	
	@Override
	public int compareTo(RootEntity obj) {
		return this.rootId.compareTo(((RootEntity)obj).rootId);
	}
	
	@AssertTrue(message = "Component List must not be empty!")
	public boolean isValid() {
		if (this.components == null || this.components.isEmpty())
			return false;
		return true;
	}

	public Integer getRootId() {
		return rootId;
	}

	public void setRootId(Integer rootId) {
		this.rootId = rootId;
	}

	public String getRootName() {
		return rootName;
	}

	public void setRootName(String rootName) {
		this.rootName = rootName;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public List<ComponentEntity> getComponents() {
		return components;
	}

	public void setComponents(List<ComponentEntity> components) {
		this.components = components;
	}

	public Integer getComponentsCount() {
		return componentsCount;
	}

	public void setComponentsCount(Integer componentsCount) {
		this.componentsCount = componentsCount;
	}

	@Override
	public String toString() {
		return "RootEntity [rootId=" + rootId + ", rootName=" + rootName + ", startDate=" + startDate
				+ ", componentsCount=" + componentsCount + "]";
	}
	
	
}

