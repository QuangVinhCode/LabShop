package com.edu.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edu.shop.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{
	
}
