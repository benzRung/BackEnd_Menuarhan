package com.example.ExampleAPI.user.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ExampleAPI.user.json.TypeFoodListJson;
import com.example.ExampleAPI.user.model.TypeFood;
import com.example.ExampleAPI.user.payload.TypeFoodPayload;
import com.example.ExampleAPI.user.service.TypeFoodService;

@Service
public class TypeFoodBusiness {

	@Autowired
	TypeFoodService typeFoodService;
	
	public TypeFoodBusiness( TypeFoodService typeFoodService) {
		super();
		this.typeFoodService = typeFoodService;
		
	}
	
	public List<TypeFoodListJson> getLisTypeFood(){
		return TypeFoodListJson.packJsons(typeFoodService.getAllTypeFoods());
	}
	
	public TypeFoodListJson getTypeId(long id) {
		return TypeFoodListJson.packJson(typeFoodService.findBtId(id));
	}
	
	public void saveType(TypeFoodPayload foodPayload) {
		TypeFood typeFood = new TypeFood(
				foodPayload.getIconType(),
				foodPayload.getNameType()
				);
		typeFoodService.save(typeFood);
	}
	
	public void updateType(long id ,TypeFoodPayload payload) {
		TypeFood typeData = typeFoodService.findBtId(id);
		typeData.setNameType(payload.getNameType());
		
	}
	
//	public void deleteTypeFood(long id) {
//		typeFoodService.deleteById(id);
//	}
//	
}
