package com.insurance.controller;


import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.model.User;
import com.insurance.repository.UserRepository;
import com.insurance.response.UserRequest;
import com.insurance.response.UserResponse;
import com.insurance.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private UserRepository repository;

	@PostMapping("/saveuser")
	public ResponseEntity<User> saveUserInsuranceDetails(@RequestBody User user) {
		User user1 = userService.saveUserDetails(user);
		return ResponseEntity.ok().body(user1);
	}

	@PutMapping("/updateuser/{id}")
	public ResponseEntity<UserResponse> updateUserw(@PathVariable Long id, @RequestBody UserRequest request) {
		UserResponse userResponse = userService.updateUser(id, request);
		return ResponseEntity.ok().body(userResponse);
	}

// API for create excel file and restore policy details.
		@GetMapping("/excel")
		public void generateExcelReport(HttpServletResponse response) throws IOException {
			response.setContentType("application/octet-stream");
			String headerKey = "Content-Disposition";
			String headerValue = "attachment;filename=policydetails.xls";
			response.setHeader(headerKey, headerValue);
			userService.generateExcel(response);
		}
	
}
