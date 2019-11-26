package org.app.domain.services;

public interface IAuditingBusinessWorkflowService {
	void audit(Integer projectId, String featureName);
}
