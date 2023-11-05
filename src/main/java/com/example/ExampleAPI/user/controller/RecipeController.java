package com.example.ExampleAPI.user.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ExampleAPI.exception.BaseException;
import com.example.ExampleAPI.user.business.RecipeBusiness;
import com.example.ExampleAPI.user.json.RecipeListJson;
import com.example.ExampleAPI.user.model.Recipe;
import com.example.ExampleAPI.user.payload.RecipePayload;
import com.example.ExampleAPI.user.service.RecipeService;



@RestController
@RequestMapping("/api")
public class RecipeController {

	@Autowired
	RecipeService recipeService;
	
	@Autowired 
	RecipeBusiness recipeBusiness;

	public RecipeController(RecipeService recipeService, RecipeBusiness recipeBusiness) {
		super();
		this.recipeService = recipeService;
		this.recipeBusiness = recipeBusiness;
	}
	
	
//	@GetMapping(value = "/recipes")
//	public ResponseEntity<List<RecipeListJson>> getAllRecipe() throws BaseException{
//		return ResponseEntity.ok(recipeBusiness.getListRecipe());
//	}
	
	@GetMapping(value = "/recipes")
	public ResponseEntity<List<RecipeListJson>> getAllType() throws BaseException{
		return ResponseEntity.ok(recipeBusiness.getListRecipe());
	}
	
	@GetMapping(value = "/recipe/{id}")
	public ResponseEntity<RecipeListJson> getRecipeById(@PathVariable("id")  long id) throws BaseException{
		return ResponseEntity.ok(recipeBusiness.getRecipeId(id));
	}

	
//	@GetMapping(value = "/recipes/type/{id}")
//	public ResponseEntity<RecipeListJson> getRecipeByTypeId(@PathVariable("id") long id) throws BaseException {
//	    TypeFood typeFood = new TypeFood();
//	    typeFood.setId(id);
//	    return ResponseEntity.ok(recipeBusiness.getRecipeByType(typeFood));
//	}
	
	
	   @GetMapping("/recipes/type/{typeId}")
	    public ResponseEntity<List<Recipe>> getRecipesByTypeId(@PathVariable Long typeId) {
	        List<Recipe> recipes = recipeService.getRecipesByTypeId(typeId);
	        return ResponseEntity.ok(recipes);
	    }
	
	@PostMapping(value = "/recipe")
	public ResponseEntity<Void> saveRecipe(@RequestBody RecipePayload payload) throws BaseException{
		recipeBusiness.saveRecipe(payload);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/recipe/update/{id}")
	public ResponseEntity<RecipeListJson> updateRecipe(@PathVariable("id") long id, @RequestBody RecipePayload payload){
		Optional<Recipe> reccipeData = recipeService.findOptionalById(id);
		if(reccipeData.isPresent()) {
			recipeBusiness.updateRecipe(id, payload);
			return new ResponseEntity<>(HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@DeleteMapping(value = "/recipe/{id}")
	public ResponseEntity<HttpStatus> deleteRecipe(@PathVariable("id") long id){
		try {
			recipeBusiness.deleteRecipe(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
