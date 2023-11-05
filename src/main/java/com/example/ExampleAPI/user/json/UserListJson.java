package com.example.ExampleAPI.user.json;

import java.util.ArrayList;
import java.util.List;

import com.example.ExampleAPI.user.model.User;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserListJson {
	
	private long id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private int age;
	
	public static UserListJson packJson(User user) {
		UserListJson ulj = new UserListJson();
		ulj.setId(user.getId());
		ulj.setFirstName(user.getFirstName());
		ulj.setLastName(user.getLastName());
		ulj.setEmail(user.getEmail());
		ulj.setPassword(user.getPassword());
		ulj.setAge(user.getAge());
		return ulj;

		
	}
	public static List<UserListJson> packJsons(List<User> users){
		List<UserListJson> userListJson = new ArrayList<UserListJson>();
		for(User user : users) {
			userListJson.add(packJson(user));
		}
		return userListJson;
	}
	
}
