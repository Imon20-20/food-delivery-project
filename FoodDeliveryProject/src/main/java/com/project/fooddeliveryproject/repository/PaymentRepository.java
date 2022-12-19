package com.project.fooddeliveryproject.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.project.fooddeliveryproject.model.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment,Long>{

	List<Payment> findByUserEmailId(String userEmailId);

}
