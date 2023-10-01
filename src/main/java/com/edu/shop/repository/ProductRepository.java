package com.edu.shop.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.edu.shop.model.InventoryReport;
import com.edu.shop.model.Product;
import java.util.List;



@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
	@Query("SELECT o FROM Product o WHERE o.price >= ?1 and o.price <= ?2")
	public Page<Product> searchByPrice(Double min, Double max,Pageable pageable);
	
	public Page<Product> findByPriceBetween(Double min, Double max,Pageable pageable);
	
	@Query(name="searchByName")
	public Page<Product> searchByName(String name,Pageable pageable);
	
	@Query("SELECT new com.edu.shop.model.InventoryReport(o.category,sum(o.price),sum(o.quantily)) "
			+ "FROM Product o GROUP BY o.category")
	public Page<InventoryReport> reportInventory(Pageable pageable);
}
