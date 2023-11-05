package com.example.ExampleAPI.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.ExampleAPI.user.model.Recipe;
import com.example.ExampleAPI.user.model.TypeFood;
import com.example.ExampleAPI.user.model.User;
import com.example.ExampleAPI.user.repository.RecipeRepository;
import com.example.ExampleAPI.user.service.impl.IRecipe;


@Service
public class RecipeService implements IRecipe{

	
	RecipeRepository recipeRepository;
	
	public RecipeService(RecipeRepository recipeRepository) {
		super();
		this.recipeRepository = recipeRepository;
	}

	@Override
	public List<Recipe> getAllRecipe() {
		// TODO Auto-generated method stub
		return recipeRepository.findAll();
	}

	@Override
	public Recipe findById(long id) {
		// TODO Auto-generated method stub
		return recipeRepository.findById(id);
	}

	

	@Override
	public Recipe findByUserId(User id) {
		// TODO Auto-generated method stub
		return recipeRepository.findByUserId(id);
	}

	@Override
	public Recipe save(Recipe recipe) {
		// TODO Auto-generated method stub
		return recipeRepository.save(recipe);
	}

	@Override
	public void deleteById(long id) {
		// TODO Auto-generated method stub
		
		recipeRepository.deleteById(id);
		
	}
	
	public Optional<Recipe> findOptionalById(long id){
		return recipeRepository.findOptionalById(id);
	}

	  public List<Recipe> getRecipesByTypeId(Long typeId) {
	        return recipeRepository.findByTypeId(typeId);
	    }

//	@Override
//	public Recipe findByTypeId(TypeFood id) {
//		// TODO Auto-generated method stub
//		return null;
//	}


}
