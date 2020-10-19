package com.app.arcx.repository;

import com.app.arcx.domain.AreaOfInterest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "area_of_interest", path = "area_of_interest")
public interface AreaOfInterestRepository extends CrudRepository<AreaOfInterest, Integer> {

}