package com.project.fooddeliveryproject.service;

import java.util.List;

import com.project.fooddeliveryproject.model.Cart;
import com.project.fooddeliveryproject.model.Payment;

public interface PaymentService {
	
	
	Payment addPayment(Payment payment, long orderId, String userEmailId);
	List<Payment> getAllPayments();
	List<Payment> getPaymentByUserEmailId(String userEmailId);

	void deletePayment(long paymentId);
	Payment getPaymentById(long paymentId);
}