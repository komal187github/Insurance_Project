package com.insurance.entityservice;

import com.insurance.entity.UserEntity;
import com.insurance.model.User;

public interface UserEntityService {

	//Save User API
	public UserEntity saveUserEntity(UserEntity userEntity);

<<<<<<< HEAD
	UserEntity getUserById(long id);

	
=======
	//Get User with multiple Policy and Nominee.	
		public UserEntity readUserEntity(Long id);
		
>>>>>>> 581467c9c37f23b4df949f33c42f4ec151750005

	
}
