package org.app.domain.services;

import java.util.Set;

import org.app.domain.RootEntity;

public interface IValidatingDomainService {

	//
	Set<String> validate(RootEntity rootEntity);

	void validateWithException(RootEntity rootEntity);

}