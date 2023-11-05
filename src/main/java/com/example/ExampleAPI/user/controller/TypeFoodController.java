package com.example.ExampleAPI.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ExampleAPI.exception.BaseException;
import com.example.ExampleAPI.user.business.TypeFoodBusiness;
import com.example.ExampleAPI.user.json.TypeFoodListJson;
import com.example.ExampleAPI.user.payload.TypeFoodPayload;
import com.example.ExampleAPI.user.service.TypeFoodService;

@RestController
@RequestMapping("/api")
public class TypeFoodController {
	@Autowired
	TypeFoodService foodService;
	@Autowired 
	TypeFoodBusiness foodBusiness;

	public TypeFoodController(TypeFoodService foodService, TypeFoodBusiness foodBusiness) {
		super();
		this.foodService = foodService;
		this.foodBusiness = foodBusiness;
	}
	
	@GetMapping(value = "/types")
	public ResponseEntity<List<TypeFoodListJson>> getAllType() throws BaseException{
		return ResponseEntity.ok(foodBusiness.getLisTypeFood());
	}
	
	@GetMapping(value = "/type/{id}")
	public ResponseEntity<TypeFoodListJson> getTypeById(@PathVariable("id")  long id) throws BaseException{
		return ResponseEntity.ok(foodBusiness.getTypeId(id));
	}
	
	@PostMapping(value = "/type")
	public ResponseEntity<Void> saveType(@RequestBody TypeFoodPayload payload) throws BaseException{
		foodBusiness.saveType(payload);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	
	
	
}
