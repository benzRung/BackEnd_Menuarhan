package com.example.ExampleAPI.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.ExampleAPI.user.model.TypeFood;
import com.example.ExampleAPI.user.repository.TypeFoodRepository;
import com.example.ExampleAPI.user.service.impl.ITypeFood;


@Service
public class TypeFoodService  implements ITypeFood {
	
	@Autowired
	TypeFoodRepository foodRepository;
	
	public TypeFoodService(TypeFoodRepository foodRepository) {
		super();
		this.foodRepository = foodRepository;
	}

	@Override
	public List<TypeFood> getAllTypeFoods() {
		// TODO Auto-generated method stub
		return foodRepository.findAll();
	}

	@Override
	public TypeFood findBtId(long id) {
		// TODO Auto-generated method stub
		return foodRepository.findById(id);
	}

	
	
	public Optional<TypeFood> finOptionalById(long id){
		return foodRepository.findOptionalById(id);
	}

	@Override
	public TypeFood save(TypeFood typeFood) {
		// TODO Auto-generated method stub
		return foodRepository.save(typeFood);	}
	

	
}
