package com.project.fooddeliveryproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.project.fooddeliveryproject.model.Food;

@Repository
public interface FoodRepository extends JpaRepository<Food, Long>{
	 
	List<Food> findByCategoryCategoryId(long categoryId);
}
