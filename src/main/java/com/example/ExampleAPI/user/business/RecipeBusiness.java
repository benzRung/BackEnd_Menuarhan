package com.example.ExampleAPI.user.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ExampleAPI.user.json.RecipeListJson;
import com.example.ExampleAPI.user.model.Recipe;
import com.example.ExampleAPI.user.model.TypeFood;
import com.example.ExampleAPI.user.model.User;
import com.example.ExampleAPI.user.payload.RecipePayload;
import com.example.ExampleAPI.user.service.RecipeService;

@Service
public class RecipeBusiness {

	@Autowired
	RecipeService recipeService;
	
	public List<RecipeListJson> getListRecipe(){
		return RecipeListJson.packJson(recipeService.getAllRecipe());
	}
	
	public RecipeListJson getRecipeId(long id) {
		return RecipeListJson.packJson(recipeService.findById(id));
	}
	
//	public RecipeListJson getRecipeName(String recipeName) {
//		return RecipeListJson.packJson(recipeService.findByRecipeName(recipeName));
//	}
	
	public RecipeListJson getRecipeUser(User user) {
		return RecipeListJson.packJson(recipeService.findByUserId(user));
	}
	
//	public RecipeListJson getRecipeByType(TypeFood typeFood) {
//		return RecipeListJson.packJson(recipeService.findByTypeId(typeFood));
//		
//	}
	
	public void saveRecipe(RecipePayload rec) {
		Recipe recipe = new Recipe(
				rec.getImage(),
				rec.getRecipeName(),
				rec.getIngredients(),
				rec.getInstructions(),
				rec.getUserId(),
				rec.getTypeId()
				);
		recipeService.save(recipe);
	}
	
	public void updateRecipe(long id,RecipePayload payload) {
		Recipe recipeData = recipeService.findById(id);
		recipeData.setImage(payload.getImage());
		recipeData.setRecipeName(payload.getRecipeName());
		recipeData.setIngredients(payload.getIngredients());
		recipeData.setInstructions(payload.getInstructions());
		recipeData.setUserId(payload.getUserId());
		recipeData.setTypeId(payload.getTypeId());
		recipeService.save(recipeData);
		
	}
	
	public void deleteRecipe(long id) {
		recipeService.deleteById(id);
	}
}
