package com.example.ExampleAPI.user.json;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.example.ExampleAPI.user.model.Recipe;
import com.example.ExampleAPI.user.model.TypeFood;
import com.example.ExampleAPI.user.model.User;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RecipeListJson implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7071183996093862256L;
	private long id;
	private String Image;
	private String RecipeName;
	private String Ingredient;
	private String Instructions;
	private User user;
	private TypeFood typeFood;
	
	
	public static RecipeListJson packJson(Recipe recipe) {
		RecipeListJson rlj = new RecipeListJson();
		rlj.setId(recipe.getId());
		rlj.setImage(recipe.getImage());
		rlj.setRecipeName(recipe.getRecipeName());
		rlj.setIngredient(recipe.getIngredients());
		rlj.setInstructions(recipe.getInstructions());
		rlj.setUser(recipe.getUserId());
		rlj.setTypeFood(recipe.getTypeId());
		return rlj;
		
	}
	
	public static List<RecipeListJson> packJson(List<Recipe> recipes){
		List<RecipeListJson> recipeListJson = new ArrayList<RecipeListJson>();
		for(Recipe recipe : recipes) {
			recipeListJson.add(packJson(recipe));
		}
		return recipeListJson;
	}
}
