package com.insurance.entitycontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
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
}
