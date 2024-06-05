package com.insurance.entitycontroller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.controller.UserController;
import com.insurance.entity.UserEntity;
import com.insurance.entityservice.UserEntityService;

@RestController
@RequestMapping("/userentity")
public class UserEntityController {

	private static final Logger logger = LoggerFactory.getLogger(UserEntityController.class);

	@Autowired
	private UserEntityService userEntityService;

	@PostMapping("/saveuser")
	public ResponseEntity<UserEntity> saveUser(@RequestBody UserEntity userEntity) {
		logger.info("UserEntityController implementaion : savaUser() method : " + userEntity);
		UserEntity entity = userEntityService.saveUserEntity(userEntity);
		return ResponseEntity.ok().body(entity);
	}

	@GetMapping("/readuser/{id}")
	public ResponseEntity<UserEntity> readUserEntity(@PathVariable long id) {
		logger.info("UserEntityController implementaion : readUserEntity() method");
		UserEntity user = userEntityService.readUserEntity(id);
		return ResponseEntity.ok().body(user);

	}

	@PutMapping("/updateuser/{userId}")
	public ResponseEntity<UserEntity> updateUser(@PathVariable long userId, @RequestBody UserEntity updatedUser) {
		logger.info("UserEntityController implementaion : updateUser() method : " + updatedUser);
		UserEntity existingUser = userEntityService.getUserById(userId);

		if (existingUser == null) {
			return ResponseEntity.notFound().build();
		}
		existingUser.setFirstName(updatedUser.getFirstName());
		existingUser.setLastName(updatedUser.getLastName());
		existingUser.setDateOfBirth(updatedUser.getDateOfBirth());
		existingUser.setMobileNumber(updatedUser.getMobileNumber());
		existingUser.setGender(updatedUser.getGender());
		existingUser.setEmail(updatedUser.getEmail());
		existingUser.setAdharCard(updatedUser.getAdharCard());
		existingUser.setPanCard(updatedUser.getPanCard());
		existingUser.setPolicylist(updatedUser.getPolicylist());
		existingUser.setNomineelist(updatedUser.getNomineelist());

		UserEntity updatedEntity = userEntityService.saveUserEntity(existingUser);
		return ResponseEntity.ok().body(updatedEntity);
	}

	@DeleteMapping("/deleteuser/{id}")
	public ResponseEntity<String> deleteByUserId(@PathVariable long id) {
		logger.info("UserEntityController implementaion : deleteByUserId() method");
		userEntityService.deleteUserEntity(id);
		return ResponseEntity.ok("Account is deleted Sucessfully..!!");
	}

	@GetMapping("/csvpolicyfile")
	public void generateCsvReport(HttpServletResponse response) throws IOException {
		logger.info("UserEntityController implementaion : generateCsvReport() method for all policy details ");
		response.setContentType("application/octet-stream");
		String headerKey = "Content-Disposition";
		String headerValue = "attachment;filename=policyentity.csv";
		response.setHeader(headerKey, headerValue);
		userEntityService.generateCsvFile(response);
	}

}