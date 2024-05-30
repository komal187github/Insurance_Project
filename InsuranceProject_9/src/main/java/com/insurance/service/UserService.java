package com.insurance.service;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import com.insurance.model.User;
import com.insurance.response.UserRequest;
import com.insurance.response.UserResponse;

public interface UserService<UserRequet> {

//Save User with multiple Policy,Premium and Nominee.	
	public User saveUserDetails(User user);

//Update User with multiple Policy,Premium and Nominee.	
	public UserResponse updateUser(Long id, UserRequest request);


//Get User with multiple Policy,Premium and Nominee.	
	public User readUser(Long id);

//Delete User with multiple Policy,Premium and Nominee.		
	public void deleteUser(Long id);

//Excel file Operation	
	public void generateExcel(HttpServletResponse response) throws IOException;








}
