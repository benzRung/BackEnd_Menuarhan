package com.example.ExampleAPI.user.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.ExampleAPI.user.model.TypeFood;

public interface TypeFoodRepository extends JpaRepository<TypeFood, Long>{
	TypeFood findById(long id);
	Optional<TypeFood> findOptionalById(long id);

}
