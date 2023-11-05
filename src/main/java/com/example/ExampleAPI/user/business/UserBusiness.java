package com.example.ExampleAPI.user.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ExampleAPI.user.json.UserListJson;
import com.example.ExampleAPI.user.model.User;
import com.example.ExampleAPI.user.payload.UserPayload;
import com.example.ExampleAPI.user.service.UserService;

@Service
public class UserBusiness {
	
	@Autowired
	UserService userService;
	
	public List<UserListJson> getListUser(){
		return UserListJson.packJsons(userService.getAllUsers());
	}
	
	public UserListJson getUserId(Long id){
		return UserListJson.packJson(userService.findById(id));
	}
	
	public UserListJson getUserByEmail(String email){
		return UserListJson.packJson(userService.findByEmail(email));
	}
	
	public UserListJson getUserByEmailAndPassword(String email, String password){
		return UserListJson.packJson(userService.findByEmailAndPassword(email,password));
	}
	
	public void saveUser(UserPayload usr) {
		// TODO Auto-generated method stub
		User user = new User(
				usr.getFirstName(),
				usr.getLastName(),
				usr.getEmail(),
				usr.getPassword(),
				usr.getAge()
				);
		userService.save(user);
						

	}
	
	public void updateUser(long id, UserPayload payload) {
		User userData = userService.findById(id);
		userData.setFirstName(payload.getFirstName());
		userData.setLastName(payload.getLastName());
		userData.setAge(payload.getAge());
		userService.save(userData);
	}
	
	public void deleteUser(long id) {
		userService.deleteById(id);
		
	}
	
	
}
