package com.insurance.entityservice;

import com.insurance.entity.UserEntity;
import com.insurance.model.User;

public interface UserEntityService {

	//Save User API
	public UserEntity saveUserEntity(UserEntity userEntity);


	UserEntity getUserById(long id);

	

	//Get User with multiple Policy and Nominee.	
		public UserEntity readUserEntity(Long id);
		

	
}
