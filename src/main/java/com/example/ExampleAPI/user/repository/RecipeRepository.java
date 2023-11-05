package com.example.ExampleAPI.user.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.ExampleAPI.user.model.Recipe;
import com.example.ExampleAPI.user.model.User;




public interface RecipeRepository extends JpaRepository<Recipe, Long> {
		Recipe findById(long id);
	    Recipe findByUserId(User id);
	    Optional<Recipe> findOptionalById(long id);

	    @Query("SELECT r FROM Recipe r WHERE r.typeId.id = :id")
	    List<Recipe> findByTypeId(@Param("id") Long typeId);
	

}
