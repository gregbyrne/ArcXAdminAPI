package com.app.arcx.repository;

import com.app.arcx.domain.AdditionalInformation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "additional_information", path = "additional_information")
public interface AdditionalInformationRepository extends CrudRepository<AdditionalInformation, Integer> {

}
