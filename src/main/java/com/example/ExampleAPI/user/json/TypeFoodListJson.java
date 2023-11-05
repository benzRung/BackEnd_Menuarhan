package com.example.ExampleAPI.user.json;



import java.util.ArrayList;
import java.util.List;


import com.example.ExampleAPI.user.model.TypeFood;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TypeFoodListJson {
	private long id;
	private String icon;
	private String nameType;

	
	
	public static TypeFoodListJson packJson(TypeFood typeFood) {
		TypeFoodListJson flj = new TypeFoodListJson();
		flj.setId(typeFood.getId());
		flj.setIcon(typeFood.getIconType());
		flj.setNameType(typeFood.getNameType());
		
		return flj;
		
	}
	
	public static List<TypeFoodListJson> packJsons(List<TypeFood> typeFoods){
		List<TypeFoodListJson> foodListJsons = new ArrayList<TypeFoodListJson>();
		for(TypeFood typeFood : typeFoods) {
			foodListJsons.add(packJson(typeFood));
			
		}
		return foodListJsons;
		
	}	
}
