package com.prac.demorestseervices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.prac.demorestseervices.Dao.UserDaoServcie;
import com.prac.demorestseervices.model.User;

@RestController
public class UserController {
	
	@Autowired
	private UserDaoServcie service;
	
	@GetMapping("/users")
	public List<User> findAllUsers(){
		return service.findAll();
	}
	
	@GetMapping("users/{id}")
	public User getUserById(@PathVariable int id) {
		
		return service.getUserById(id);
	}

}
