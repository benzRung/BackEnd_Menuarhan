package com.example.ExampleAPI.user.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.ExampleAPI.exception.BaseException;
import com.example.ExampleAPI.user.business.UserBusiness;

import com.example.ExampleAPI.user.json.UserListJson;

import com.example.ExampleAPI.user.model.User;
import com.example.ExampleAPI.user.payload.UserPayload;
import com.example.ExampleAPI.user.repository.UserRepositoy;
import com.example.ExampleAPI.user.service.UserService;


@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	UserBusiness usrBusiness;
	
	@Autowired
	UserRepositoy userRepositoy;
	

	public UserController(UserService studentservice) {
		this.userService = studentservice;
		// TODO Auto-generated constructor stub
	}
	
	@PostMapping(value = "/users")
	public ResponseEntity<Void> saveUser(@RequestBody UserPayload payload) throws BaseException{
		usrBusiness.saveUser(payload);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	

	
	@GetMapping(value = "/users")
	public ResponseEntity<List<UserListJson>> getAllUser() throws BaseException{
		return ResponseEntity.ok(usrBusiness.getListUser());
	}
	
	
	@GetMapping(value = "/users/{id}")
	public ResponseEntity<UserListJson> getById(@PathVariable("id")  long id) throws BaseException{
		return ResponseEntity.ok(usrBusiness.getUserId(id));
	}
	
	
	
	
	@PutMapping(value = "/users/{id}")
	public ResponseEntity<UserListJson> updateUser(@PathVariable("id") long id, @RequestBody UserPayload payload){
		Optional<User> stdData = userService.findOptionalById(id);
		if(stdData.isPresent()) {
			usrBusiness.updateUser(id, payload);
			return new ResponseEntity<>(HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	 @PostMapping("/login")
	    public User Login(@RequestBody User user) {
	        User oldUSer = userRepositoy.findByEmailAndPassword(user.getEmail(), user.getPassword());
	        return oldUSer;
	    }
	
	
	@DeleteMapping(value = "/user/{id}")
	public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") long id){
		try {
			usrBusiness.deleteUser(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	
	
	

}
