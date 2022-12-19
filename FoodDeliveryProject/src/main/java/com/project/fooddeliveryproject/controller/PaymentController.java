package com.project.fooddeliveryproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.fooddeliveryproject.model.Cart;
import com.project.fooddeliveryproject.model.Payment;
import com.project.fooddeliveryproject.service.PaymentService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api/payment")
public class PaymentController {
	@Autowired
	private PaymentService paymentService;

	public PaymentController(PaymentService paymentService) {
		super();
		this.paymentService = paymentService;
	}
	
	//Making Payment
	@PostMapping("add/{orderId}/{userEmailId}")
	public ResponseEntity<Payment> addPayment (@RequestBody Payment payment, @PathVariable("orderId") long orderId, @PathVariable("userEmailId") String userEmailId)
	{
		return new ResponseEntity<Payment>(paymentService.addPayment(payment,orderId,userEmailId), HttpStatus.CREATED);
	}
	
	//Getting List Of Payment
	@GetMapping
	public List<Payment> getAllPayments()
	{
		return paymentService.getAllPayments();
	}
	
	//get Payment By Id(for receipt)
	@GetMapping("{paymentId}")
	public ResponseEntity<Payment> getPaymentById(@PathVariable("paymentId") long paymentId)
	{
		return new ResponseEntity <Payment> (paymentService.getPaymentById(paymentId), HttpStatus.OK);
	}
	
	@GetMapping("/user/{userEmailId}")
	public List<Payment> getPaymentByUserEmailId(@PathVariable("userEmailId") String userEmailId)
	{
		return paymentService.getPaymentByUserEmailId(userEmailId);
	}
	//To Delete Payment
	@DeleteMapping("{paymentId}")
	public ResponseEntity <Boolean> deletePayment(@PathVariable("paymentId") long paymentId)
	{
		paymentService.deletePayment(paymentId);
		boolean flag = true;
		return new ResponseEntity <Boolean> (flag, HttpStatus.OK);
	}

}