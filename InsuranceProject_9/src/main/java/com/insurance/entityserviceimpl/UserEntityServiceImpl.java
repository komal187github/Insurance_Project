package com.insurance.entityserviceimpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.entity.UserEntity;
import com.insurance.entityrepository.NomineeEntityRepository;
import com.insurance.entityrepository.PolicyEntityRepository;
import com.insurance.entityrepository.UserEntityRepository;
import com.insurance.entityservice.UserEntityService;
import com.insurance.exception.IdNotFoundException;
import com.insurance.exception.ResourceNotFoundException;


@Service
public class UserEntityServiceImpl implements UserEntityService {

	@Autowired
	private UserEntityRepository userEntityRepository;
	@Autowired
	private NomineeEntityRepository nomineeEntityRepository;
	@Autowired
	private PolicyEntityRepository policyEntityRepository;
	
	//save user
	@Override
	public UserEntity saveUserEntity(UserEntity userEntity) {
		return userEntityRepository.save(userEntity);
	}

//read user
	@Override
	public UserEntity readUserEntity(Long id) {
		return userEntityRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Given Id is Does not exist : " + id));
	}

	


	



	

	}

