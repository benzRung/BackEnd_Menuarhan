package com.example.ExampleAPI.user.excption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.ExampleAPI.exception.BaseException;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UserException extends BaseException{

	/**
	 * 
	 */
//	private static final long serialVersionUID = -5095188350865406154L;

	public UserException(String code, HttpStatus status) {
		super("student" + code, status);
		// TODO Auto-generated constructor stub
	}
	
	public static UserException emptyStudent() {
		return new UserException("findUser.notFound", HttpStatus.BAD_REQUEST);
	}

}
