package com.example.ExampleAPI.user.service.impl;

import java.util.List;

import com.example.ExampleAPI.user.model.Recipe;
import com.example.ExampleAPI.user.model.TypeFood;
import com.example.ExampleAPI.user.model.User;

public interface IRecipe {
	List<Recipe> getAllRecipe();
	Recipe findById(long id);
//	Recipe findByRecipeName(String recipeName);
	Recipe findByUserId(User id);
//	Recipe findByTypeId(TypeFood id);
	Recipe save(Recipe recipe);
	
	void deleteById(long id);
}
