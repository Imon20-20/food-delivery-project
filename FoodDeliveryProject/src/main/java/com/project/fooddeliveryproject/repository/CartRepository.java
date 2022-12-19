package com.project.fooddeliveryproject.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.fooddeliveryproject.model.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long>{
	
	List<Cart> findByUserEmailId(String userEmailId);
	Cart findByFoodFoodIdAndUserEmailId(long foodId,String userEmailId);
	@Transactional
	void deleteByUserEmailId(String userEmailId);
}
