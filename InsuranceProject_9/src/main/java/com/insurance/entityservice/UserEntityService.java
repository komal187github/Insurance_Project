package com.insurance.entityservice;

import com.insurance.entity.UserEntity;

public interface UserEntityService {

	//Save User API
	public UserEntity saveUserEntity(UserEntity userEntity);

	UserEntity getUserById(long id);

	

	
}
