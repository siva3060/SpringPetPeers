package com.hcl.pp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.pp.dtos.*;
import com.hcl.pp.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
	
	@PostMapping("/add")
	public ResponseEntity<String> addUsers(@RequestBody UserReqDTO user){
	String message= userService.addUsers(user);
	return new ResponseEntity<String>(message, HttpStatus.CREATED);
	}
	@PostMapping("/buyPets")
	public ResponseEntity<String> buyPets(@RequestBody UserPetDTO userpet){
	String message= userService.buyPets(userpet);
	return new ResponseEntity<String>(message, HttpStatus.CREATED);
}
}