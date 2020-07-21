package com.cts.ims.controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cts.ims.model.User;
import com.cts.ims.repos.UserRepo;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserRepo repo;

	@RequestMapping(value="/getuser/{id}", method = RequestMethod.GET)
	public User getUserById(@PathVariable("id") int id) {
		System.out.println(id);
		return repo.findById(id);
		
	}
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public User addUser(@RequestBody User user) {
		Date date = new Date();
		user.setCreatedTime(date);
		return repo.save(user);
		
	}
}
