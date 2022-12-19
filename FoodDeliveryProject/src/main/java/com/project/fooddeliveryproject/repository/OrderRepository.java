package com.project.fooddeliveryproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

//import com.project.fooddeliveryproject.model.Cart;
import com.project.fooddeliveryproject.model.Order;

public interface OrderRepository extends JpaRepository<Order,Long>{

	List<Order> findByUserEmailId(String userEmailId);
	 Order findByTotalAndUserEmailId(float total,String userEmailId);

}
