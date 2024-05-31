package com.insurance.entitycontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.entity.UserEntity;
import com.insurance.entityservice.UserEntityService;

@RestController
@RequestMapping("/userentity")
public class UserEntityController {

	@Autowired
	private UserEntityService userEntityService;
	
	@PostMapping ("/saveuser")
	public ResponseEntity<UserEntity> saveUser (@RequestBody UserEntity userEntity){
		UserEntity entity=userEntityService.saveUserEntity(userEntity);
		return ResponseEntity.ok().body(entity);
	}
	   @PutMapping("/updateuser/{userId}")
	    public ResponseEntity<UserEntity> updateUser(@PathVariable long userId, @RequestBody UserEntity updatedUser) {
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
}
