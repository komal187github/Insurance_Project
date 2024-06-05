package com.insurance.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
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

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@Autowired
	private UserRepository repository;

	@PostMapping("/saveuser")
	public ResponseEntity<User> saveUserInsuranceDetails(@RequestBody User user) {
		logger.info("UserController implementaion : savaUserInsuranceDeatils() method : " + user);
		User user1 = userService.saveUserDetails(user);
		return ResponseEntity.ok().body(user1);
	}

	@PatchMapping("/updateuser/{id}")
	public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
		logger.info("UserController implementaion : updateUsere() method : " + user);
		User updateduser = userService.updateUser(id, user);
		return ResponseEntity.ok().body(updateduser);
	}

	@GetMapping("/readuser/{id}")
	public ResponseEntity<User> readUser(@PathVariable long id) {
		logger.info("UserController implementaion : readUser() method");
		User user = userService.readUser(id);
		return ResponseEntity.ok().body(user);
	}

	@DeleteMapping("/deletebyid/{id}")
	public ResponseEntity<String> deleteByUserId(@PathVariable long id) {
		logger.info("UserController implementaion : deleteByUserId() method");
		userService.deleteUser(id);
		return ResponseEntity.ok("Account is deleted Sucessfully..!!");
	}

	@GetMapping("/excel")
	public void generateExcelReport(HttpServletResponse response) throws IOException {
		logger.info("UserController implementaion : generateExcelReport() method for All policy details");
		response.setContentType("application/octet-stream");
		String headerKey = "Content-Disposition";
		String headerValue = "attachment;filename=policydetails.xls";
		response.setHeader(headerKey, headerValue);
		userService.generateExcel(response);
	}

}
