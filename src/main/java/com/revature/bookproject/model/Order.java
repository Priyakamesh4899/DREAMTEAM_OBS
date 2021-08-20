package com.revature.bookproject.model;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="orders")
public class Order {
	@Id
	@GeneratedValue
	private int orderId;
	@Column(name="orderDate")
	private Date orderDate;
	@Column(name="status")
	private String status;
	@OneToMany(mappedBy="order")
	private Set<OrderDetails> orderDetails=new HashSet<>();
	
	//@ManyToMany
/*	@ManyToMany
    @JoinTable(
        name = "Book_orders", 
        joinColumns = { @JoinColumn(name = "orderId") }, 
        inverseJoinColumns = { @JoinColumn(name = "bid",referencedColumnName="id") }
    )*/
	//@JoinColumn(name="bid",referencedColumnName="id")
	//private List<Books> book;
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="userid",referencedColumnName="id")
	private User user;
	
	
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(Date orderDate, String status, User user) {
		super();
		this.orderDate = orderDate;
		this.status = status;
		this.user = user;
	}
	
	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Set<OrderDetails> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(Set<OrderDetails> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void addOrderDetail(List<OrderDetails> orderDetail)
	{
		this.orderDetails.addAll(orderDetail);
	}

	

}
