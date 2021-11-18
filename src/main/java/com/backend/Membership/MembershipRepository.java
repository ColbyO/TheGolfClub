package com.backend.Membership;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.Membership.Membership;

public interface MembershipRepository extends JpaRepository<Membership, Long> {
    List<Membership> findByMembershipFirstName(String lirstName);
    List<Membership> findByMembershipLastName(String lastName);
}
