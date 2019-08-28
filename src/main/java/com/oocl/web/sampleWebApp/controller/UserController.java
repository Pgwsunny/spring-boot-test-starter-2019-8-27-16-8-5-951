package com.oocl.web.sampleWebApp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oocl.web.sampleWebApp.User;

@RestController
@RequestMapping("/users")

public class UserController {

	private static List<User> users = new ArrayList<User>();
	@PostMapping(consumes = "application/json")
	public ResponseEntity<User> adduser(@RequestBody User user){
		users.add(user);
		return ResponseEntity.created(null).build();
	}
	
	@GetMapping
	public ResponseEntity<List<User>> users(){    
		return ResponseEntity.ok(users);
	}
}
