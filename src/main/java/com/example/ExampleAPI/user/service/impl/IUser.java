package com.example.ExampleAPI.user.service.impl;

import java.util.List;

import com.example.ExampleAPI.user.model.User;

public interface IUser {
	List<User> getAllUsers();
	User findById(long id);
	User findByEmail(String email);
	User findByEmailAndPassword(String email,String password);
	User save(User usr);
	void deleteById(long id);
}
