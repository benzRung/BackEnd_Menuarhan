package com.example.ExampleAPI.user.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity(name = "Recipe")
@Table(name = "Recipe")

public class Recipe {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "RecipeID")
	private Long id;
	
	@Column(name = "ImageRecipe", nullable = false,columnDefinition = "LONGTEXT")
	 private String Image;
	
	@Column(name = "RecipeName", nullable = false, columnDefinition = "LONGTEXT")
	 private String RecipeName;
	
	@Column(name = "Ingredients", nullable = false,columnDefinition = "LONGTEXT")
	private String Ingredients;
	
	
	@Column(name = "Instructions", nullable = false,columnDefinition = "LONGTEXT")
	private String Instructions;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userID")
	@Fetch(FetchMode.JOIN)
	private User userId;
	
	@ManyToOne(fetch = FetchType.EAGER) // ใช้ FetchType.LAZY หรือ FetchType.EAGER ตามต้องการ
    @JoinColumn(name = "type_id") // กำหนดชื่อคอลัมน์ในตารางของ Recipe ที่เก็บคีย์ต่าง ๆ ของ TypeFood
    private TypeFood typeId;
	

	public Recipe() {
		;
	}


	public Recipe(String image, String recipeName, String ingredients, String instructions, User userId, TypeFood typeFood) {
		super();
		Image = image;
		RecipeName = recipeName;
		Ingredients = ingredients;
		Instructions = instructions;
		this.userId = userId;
		this.typeId = typeFood;
	}
	

	
	
	
	



	

	
	
	
	
	



	
	
	
	
}
