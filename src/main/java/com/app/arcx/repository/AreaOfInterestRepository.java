package com.app.arcx.repository;

import com.app.arcx.domain.AreaOfInterest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "areaofinterest", path = "areaofinterest")
public interface AreaOfInterestRepository extends CrudRepository<AreaOfInterest, Integer> {

}
