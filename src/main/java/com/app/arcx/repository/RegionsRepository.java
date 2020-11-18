package com.app.arcx.repository;

import com.app.arcx.domain.Regions;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "regions", path = "regions")
public interface RegionsRepository extends CrudRepository<Regions, Integer> {

}
