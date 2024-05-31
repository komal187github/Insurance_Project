package com.insurance.entitycontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.entity.UserEntity;
import com.insurance.entityservice.UserEntityService;
import com.insurance.model.User;

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

	@GetMapping("/readuser/{id}")
	public ResponseEntity<UserEntity> readUserEntity(@PathVariable long id) {
		UserEntity user = userEntityService.readUserEntity(id);
		return ResponseEntity.ok().body(user);
}
}