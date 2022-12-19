package com.project.fooddeliveryproject.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "payment_table")
public class Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long paymentId;
	
	@Column(name="TOTAL_PRICE")
	private float totalPrice;
	
	@Column(name="name_on_card")
	@NotEmpty
	@Size(min=3 , message="name must contain atleast 3 characters")
	private String nameOnCard;

	@Column(name="card_number", unique=true)
	@NotEmpty
	@Size(min=16 , max=16,message="cardNumber must contain 16 digits")
	private String cardNumber;

	@Column(name="exp_year")
	private String expYear;

	@Column(name="cvv")
	@NotNull
	private int cvv;
	
	@Column(name="paid_date")
	private String paidDate;
	
	@ManyToOne( cascade=CascadeType.MERGE)
	@JoinColumn(name="userEmailId")
	@JsonIgnore
	private User user;
	
	@OneToOne( cascade=CascadeType.MERGE)
	@JoinColumn(name="orderId")
	@JsonIgnore
	private Order order;
	
	public long getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(long paymentId) {
		this.paymentId = paymentId;
	}

	public float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getNameOnCard() {
		return nameOnCard;
	}

	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getExpYear() {
		return expYear;
	}

	public void setExpYear(String expYear) {
		this.expYear = expYear;
	}

	public int getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

	public String getPaidDate() {
		return paidDate;
	}

	public void setPaidDate(String paidDate) {
		this.paidDate = paidDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Payment()
	{
		
	}

	public Payment(long paymentId, float totalPrice,
			@NotEmpty @Size(min = 3, message = "name must contain atleast 3 characters") String nameOnCard,
			@NotEmpty @Size(min = 16, max = 16, message = "cardNumber must contain 16 digits") String cardNumber,
			String expYear, @NotNull int cvv, String paidDate, User user, Order order) {
		super();
		this.paymentId = paymentId;
		this.totalPrice = totalPrice;
		this.nameOnCard = nameOnCard;
		this.cardNumber = cardNumber;
		this.expYear = expYear;
		this.cvv = cvv;
		this.paidDate = paidDate;
		this.user = user;
		this.order = order;
	}
	
}
