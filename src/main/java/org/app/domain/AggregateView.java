package org.app.domain;

public class AggregateView {
	private Integer rootId;
	protected Integer componentsCount = 0;
	
	public Integer getRootId() {
		return rootId;
	}
	public void setRootId(Integer rootId) {
		this.rootId = rootId;
	}
	public Integer getComponentsCount() {
		return componentsCount;
	}
	public void setComponentsCount(Integer componentsCount) {
		this.componentsCount = componentsCount;
	}
	public AggregateView(Integer rootId, Integer componentsCount) {
		super();
		this.rootId = rootId;
		this.componentsCount = componentsCount;
	}
	@Override
	public String toString() {
		return "AggregateView [rootId=" + rootId + ", componentsCount=" + componentsCount + "]";
	}
	
	
}
