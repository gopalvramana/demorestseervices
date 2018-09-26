package com.prac.demorestseervices.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.prac.demorestseervices.Dao.UserDaoServcie;
import com.prac.demorestseervices.Exception.UserNotFoundException;
import com.prac.demorestseervices.model.User;



@RestController
public class UserController {

	@Autowired
	private UserDaoServcie service;

	@GetMapping("/users")
	public List<User> findAllUsers() {
		return service.findAll();
	}

	@GetMapping("users/{id}")
	public User getUserById(@PathVariable int id) {

		User user = service.getUserById(id);
		
		if(user==null) {
			throw new UserNotFoundException("id-");
		}
		
		return user;
	}

	@PostMapping("/users")
	public ResponseEntity createUser(@RequestBody User user) {

		service.Save(user);
		
		URI location =  ServletUriComponentsBuilder
				        .fromCurrentRequest().path("/{id}")
				        .buildAndExpand(user.getId())
				        .toUri();
		
		return ResponseEntity.created(location).build();
		
	}

}
