package com.insurance.entityserviceimpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.entity.UserEntity;
import com.insurance.entityrepository.UserEntityRepository;
import com.insurance.entityservice.UserEntityService;


@Service
public class UserEntityServiceImpl implements UserEntityService {

	@Autowired
	private UserEntityRepository userEntityRepository;
	
	@Override
	public UserEntity saveUserEntity(UserEntity userEntity) {
		return userEntityRepository.save(userEntity);
	}

	


	



	

	}

