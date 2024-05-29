package com.insurance.service;

import com.insurance.model.User;
import com.insurance.response.UserRequest;
import com.insurance.response.UserResponse;

public interface UserService<UserRequet> {

	public User saveUserDetails(User user);

	public UserResponse updateUser(Long id, UserRequest request);

	public UserResponse getUserDetails(Long id);

}
