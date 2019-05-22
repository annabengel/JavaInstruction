package com.mma.business;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Invoice {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String orderNumber;
	private String customerName;
	private LocalDate orderDate; 
	private double total;
	
	
	public Invoice() {
		super();
	}


	public Invoice(int id, String orderNumber, String customerName, LocalDate orderDate, double total) {
		super();
		this.id = id;
		this.orderNumber = orderNumber;
		this.customerName = customerName;
		this.orderDate = orderDate;
		this.total = total;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getOrderNumber() {
		return orderNumber;
	}


	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}


	public String getCustomerName() {
		return customerName;
	}


	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	public LocalDate getOrderDate() {
		return orderDate;
	}


	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}


	public double getTotal() {
		return total;
	}


	public void setTotal(double total) {
		this.total = total;
	}


	@Override
	public String toString() {
		return "Invoice [id=" + id + ", orderNumber=" + orderNumber + ", customerName=" + customerName + ", orderDate="
				+ orderDate + ", total=" + total + "]";
	}
	
	

}
