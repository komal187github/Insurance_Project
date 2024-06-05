package com.insurance.entityrepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.insurance.entity.UserEntity;

@Repository
public interface UserEntityRepository extends JpaRepository<UserEntity, Long> {

}
