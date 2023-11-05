package com.example.ExampleAPI.user.payload;

import com.example.ExampleAPI.user.model.TypeFood;
import com.example.ExampleAPI.user.model.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RecipePayload {
	private String Image;
	private String RecipeName;
	private String Ingredients;
	private String Instructions;
	private User userId;
	private TypeFood typeId;
}
