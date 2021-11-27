package com.backend.repositories;

import java.util.List;

import com.backend.models.MembershipType;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(collectionResourceRel = "MembershipType", path = "MembershipType")
public interface MembershipTypeRepository extends PagingAndSortingRepository<MembershipType, Long> {
    List<MembershipType> findByType(@Param("type") String type);
    List<MembershipType> findByPlan(@Param("plan") String plan);
}
