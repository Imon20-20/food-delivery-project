package com.project.fooddeliveryproject.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.fooddeliveryproject.exception.ResourceNotFoundException;
import com.project.fooddeliveryproject.model.Cart;
import com.project.fooddeliveryproject.model.Order;
import com.project.fooddeliveryproject.model.Payment;
import com.project.fooddeliveryproject.model.User;
import com.project.fooddeliveryproject.repository.PaymentRepository;
import com.project.fooddeliveryproject.service.OrderService;
import com.project.fooddeliveryproject.service.PaymentService;
import com.project.fooddeliveryproject.service.UserService;

@Service
public class PaymentServiceImpl implements PaymentService{

	@Autowired
	private PaymentRepository paymentRepository;
	private UserService userService;
	private OrderService orderService;
	
	public PaymentServiceImpl(PaymentRepository paymentRepository,UserService userService,OrderService orderService) {
		super();
		this.paymentRepository = paymentRepository;
		this.userService = userService;
		this.orderService = orderService;
		
	}

	@Override
	public Payment addPayment(Payment payment, long orderId, String userEmailId) {
		// TODO Auto-generated method stub
		Order order=orderService.getOrderById(orderId);
		User user=userService.getUserByEmailId(userEmailId);
		payment.setOrder(order);
		payment.setUser(user);
		payment.setTotalPrice(order.getTotal());
		return paymentRepository.save(payment);	
		
	}

	@Override
	public List<Payment> getAllPayments() {
		// TODO Auto-generated method stub
		return paymentRepository.findAll();
	}

	@Override
	public void deletePayment(long paymentId) {
		// TODO Auto-generated method stub
		paymentRepository.findById(paymentId).orElseThrow(()->new ResourceNotFoundException("Payment","PaymentId",paymentId)); 
		paymentRepository.deleteById(paymentId);

	}

	@Override
	public Payment getPaymentById(long paymentId) {
		// TODO Auto-generated method stub
		return paymentRepository.findById(paymentId).orElseThrow(()->new ResourceNotFoundException("Payment","PaymentId",paymentId)); 
	}

	@Override
	public List<Payment> getPaymentByUserEmailId(String userEmailId) {
		// TODO Auto-generated method stub
		return paymentRepository.findByUserEmailId(userEmailId);
	}

}
