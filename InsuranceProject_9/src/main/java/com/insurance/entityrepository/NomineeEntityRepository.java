package com.insurance.entityrepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.insurance.entity.NomineeEntity;

@Repository
public interface NomineeEntityRepository extends JpaRepository<NomineeEntity, Long> {

}
