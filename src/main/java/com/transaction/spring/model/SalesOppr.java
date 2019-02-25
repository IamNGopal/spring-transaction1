package com.transaction.spring.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 * The persistent class for the sales_oppr database table.
 * 
 */
@Entity
@Table(name = "sales_oppr")
@NamedQuery(name = "SalesOppr.findAll", query = "SELECT a FROM SalesOppr a")
public class SalesOppr implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "oppr_id", unique = true, nullable = false)
	private int opprId;

	@Column(name = "oppr_contact_id", nullable = false)
	private int opprContactId;

	@Column(name = "oppr_customer_id", nullable = false)
	private int opprCustomerId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "oppr_date")
	private Date opprDate;

	@Lob
	@Column(name = "oppr_desc", nullable = false)
	private String opprDesc;

	@Column(name = "oppr_no", nullable = false)
	private int opprNo;

	@Column(name = "oppr_title", nullable = false, length = 255)
	private String opprTitle;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "oppr_customer_id", referencedColumnName = "customer_id", insertable = false, updatable = false)
	private Customer customer;

	@OneToMany(mappedBy = "salesOppr")
	private List<Ticket> tickets;

	@Transient
	private String customerName;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "oppr_contact_id", referencedColumnName = "contact_id", insertable = false, updatable = false)
	private CustomerContact customerContact;

	@Transient
	private String contactFname;

	@Transient
	private String contactLname;

	public SalesOppr() {
	}

	public int getOpprId() {
		return this.opprId;
	}

	public void setOpprId(int opprId) {
		this.opprId = opprId;
	}

	public int getOpprContactId() {
		return this.opprContactId;
	}

	public void setOpprContactId(int opprContactId) {
		this.opprContactId = opprContactId;
	}

	public int getOpprCustomerId() {
		return this.opprCustomerId;
	}

	public void setOpprCustomerId(int opprCustomerId) {
		this.opprCustomerId = opprCustomerId;
	}

	public Date getOpprDate() {
		return this.opprDate;
	}

	public void setOpprDate(Date opprDate) {
		this.opprDate = opprDate;
	}

	public String getOpprDesc() {
		return this.opprDesc;
	}

	public void setOpprDesc(String opprDesc) {
		this.opprDesc = opprDesc;
	}

	public int getOpprNo() {
		return this.opprNo;
	}

	public void setOpprNo(int opprNo) {
		this.opprNo = opprNo;
	}

	public String getOpprTitle() {
		return this.opprTitle;
	}

	public void setOpprTitle(String opprTitle) {
		this.opprTitle = opprTitle;
	}

	public Customer getCustomer() {
		return customer;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public CustomerContact getCustomerContact() {
		return customerContact;
	}

	public void setCustomerContact(CustomerContact customerContact) {
		this.customerContact = customerContact;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getContactFname() {
		return contactFname;
	}

	public void setContactFname(String contactFname) {
		this.contactFname = contactFname;
	}

	public String getContactLname() {
		return contactLname;
	}

	public void setContactLname(String contactLname) {
		this.contactLname = contactLname;
	}

	public List<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}

}