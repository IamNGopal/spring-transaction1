package com.transaction.spring.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


/**
 * The persistent class for the customer database table.
 * 
 */
@Entity
@Table(name="customer")
@NamedQuery(name="Customer.findAll", query="SELECT a FROM Customer a")
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="customer_id", unique=true, nullable=false)
	private int customerId;

	@Column(name="customer_name", nullable=false, length=255)
	private String customerName;
	
	@OneToMany(mappedBy = "customer")
	private List<CustomerContact> CustomerContact;
	
	@OneToMany(mappedBy = "customer")
	private List<SalesOppr> salesOppr;
	
	public Customer() {
	}

	public int getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return this.customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public List<SalesOppr> getSalesOppr() {
		return salesOppr;
	}

	public void setSalesOppr(List<SalesOppr> salesOppr) {
		this.salesOppr = salesOppr;
	}

	public List<CustomerContact> getCustomerContact() {
		return CustomerContact;
	}

	public void setCustomerContact(List<CustomerContact> customerContact) {
		CustomerContact = customerContact;
	}

	


}