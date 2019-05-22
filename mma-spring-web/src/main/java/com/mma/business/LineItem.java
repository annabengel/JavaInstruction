package com.mma.business;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class LineItem {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn (name= "invoiceId")
	private Invoice invoice;
	@ManyToOne
	@JoinColumn (name= "productId")
	private Product product;
	private int quantity;
	

	public LineItem() {
		super();
	}

	public LineItem(int id, Invoice invoice, Product product, int quantity) {
		super();
		this.id = id;
		this.invoice = invoice;
		this.product = product;
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "LineItem [id=" + id + ", invoice=" + invoice+ ", product=" + product + ", quantity=" + quantity
				+ "]";
	}

	

}
