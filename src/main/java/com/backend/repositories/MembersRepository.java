package com.backend.repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.backend.models.Members;

@Repository
@RepositoryRestResource(collectionResourceRel = "Members", path = "Members")
public interface MembersRepository extends PagingAndSortingRepository<Members, Long> {
    List<Members> findByFirstName(@Param("firstName") String firstName);
    List<Members> findByLastName(@Param("lastName") String lastName);
    List<Members> findByAddress(@Param("address") String address);
    List<Members> findByEmail(@Param("email") String email);
    List<Members> findByPhoneNumber(@Param("phoneNumber") int phoneNumber);
}