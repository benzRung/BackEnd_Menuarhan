package com.example.ExampleAPI.user.model;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity(name = "User")
@Table(
		name = "user",
		uniqueConstraints = {
				@UniqueConstraint(name = "user_email_unique", columnNames = "email")
		})
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "first_name", nullable = false)
	private String firstName;
	
	@Column(name = "last_name", nullable = false)
	private String lastName;
	
	@Column(name = "email",unique = true ,nullable = false)
	private String email;
	
	@Column(name = "password",nullable = false)
	private String password;
	
	@Column(name = "age",nullable = false)
	private Integer age;
	
	public User() {
		;
		}

	public User(String firstName, String lastName, String email,String password, Integer age) {
		super();

		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.age = age;
	}
	

	



	
	
	
	
}
