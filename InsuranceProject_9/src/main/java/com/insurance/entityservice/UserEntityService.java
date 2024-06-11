package com.insurance.entityservice;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import com.insurance.entity.UserEntity;

public interface UserEntityService {

	// Save User API
	public UserEntity saveUserEntity(UserEntity userEntity);

	// update api
	UserEntity getUserById(long id);

	// Get User with multiple Policy and Nominee.
	public UserEntity readUserEntity(Long id);

	
	
	//Delete User with multiple Policy,Premium and Nominee.		
		public void deleteUserEntity(Long id);
		
		//Csv file Operation	
		public void generateCsvFile(HttpServletResponse response) throws IOException;


	
}
