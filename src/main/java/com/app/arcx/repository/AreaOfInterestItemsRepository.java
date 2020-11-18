package com.app.arcx.repository;

import com.app.arcx.domain.AreaOfInterestItems;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "area_of_interest_items", path = "area_of_interest_items")
public interface AreaOfInterestItemsRepository extends CrudRepository<AreaOfInterestItems, Integer> {

}
