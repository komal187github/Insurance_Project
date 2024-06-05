package com.insurance.entityrepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.insurance.entity.PolicyEntity;

@Repository
public interface PolicyEntityRepository extends JpaRepository<PolicyEntity, Long> {

}
