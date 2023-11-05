package com.example.ExampleAPI.user.service.impl;

import java.util.List;


import com.example.ExampleAPI.user.model.TypeFood;

public interface ITypeFood {
	List<TypeFood> getAllTypeFoods();
	TypeFood findBtId(long id);
	TypeFood save(TypeFood typeFood);
}
