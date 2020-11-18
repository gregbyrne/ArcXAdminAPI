package com.app.arcx.repository;

import com.app.arcx.domain.AreaOfInterestSubItems;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "area_of_interest_sub_items", path = "area_of_interest_sub_items")
public interface AreaOfInterestSubItemsRepository extends CrudRepository<AreaOfInterestSubItems, Integer> {

}
