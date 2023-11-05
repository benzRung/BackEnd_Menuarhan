package com.example.ExampleAPI.user.model;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity(name = "Type")
@Table(
		name = "type")
public class TypeFood {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "icon", nullable = false,columnDefinition = "LONGTEXT")
	 private String iconType;
	
	@Column(name = "type", nullable = false,columnDefinition = "LONGTEXT")
	 private String nameType;
	
	

	public TypeFood() {
		super();
	}


	public TypeFood(String iconType, String nameType) {
		super();
		this.iconType = iconType;
		this.nameType = nameType;
	}
	



	
	
	
	
}
