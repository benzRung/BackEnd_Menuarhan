package com.example.ExampleAPI.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.ExampleAPI.user.model.User;
import com.example.ExampleAPI.user.repository.UserRepositoy;
import com.example.ExampleAPI.user.service.impl.IUser;
@Service
public class UserService implements IUser {

	UserRepositoy userRepositoy;

	public UserService(UserRepositoy userRepositoy) {
		this.userRepositoy = userRepositoy;
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepositoy.findAll();
	}

	@Override
	public User findById(long id) {
		// TODO Auto-generated method stub
		return userRepositoy.findById(id);
	}

	@Override
	public User findByEmail(String email) {
		// TODO Auto-generated method stub
		return userRepositoy.findByEmail(email);
	}

	@Override
	public User save(User user) {
		// TODO Auto-generated method stub
		return userRepositoy.save(user);
	}

	@Override
	public void deleteById(long id) {
		// TODO Auto-generated method stub
		userRepositoy.deleteById(id);
		
	}
	
	public Optional<User> findOptionalById(long id){
		return userRepositoy.findOptionalById(id);
	}

	@Override
	public User findByEmailAndPassword(String email, String password) {
		// TODO Auto-generated method stub
		return userRepositoy.findByEmailAndPassword(email, password);
	}

	
	
	
	
}
