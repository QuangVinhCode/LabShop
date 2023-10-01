package com.edu.shop.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "categories")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
//	@Column(length = 50)
	@Column(columnDefinition = "nvarchar(50) not null")
	@NotEmpty(message = "Name must be entered")
	@Length(max = 50,min = 3,message = "Length is between 3 and 50")
	
	private String name;
	
	@OneToMany(mappedBy = "category")	
	Set<Product> products;
}
