package com.mytheresa.Mytheresa;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, String>{
	@Query("SELECT p FROM Product p WHERE (:category IS NULL OR p.category = :category) AND (:priceLessThan < 0 OR p.originalPrice <= :priceLessThan)")
	List<Product> findProducts(@Param("category") String category, @Param("priceLessThan") int priceLessThan, Pageable pageable);

}
