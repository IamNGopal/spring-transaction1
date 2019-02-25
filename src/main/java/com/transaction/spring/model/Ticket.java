package com.transaction.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

/**
 * The persistent class for the ticket database table.
 * 
 */
@Entity
@NamedQuery(name = "Ticket.findAll", query = "SELECT t FROM Ticket t")
public class Ticket implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ticket_id")
	private int ticketId;

	@Column(name = "ticket_desc")
	private String ticketDesc;

	@Column(name = "ticket_oppr_id")
	private int ticketOpprId;

	@Column(name = "ticket_owner_id")
	private int ticketOwnerId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ticket_oppr_id", referencedColumnName = "oppr_id", insertable = false, updatable = false)
	private SalesOppr salesOppr;

	public Ticket() {
	}

	public int getTicketId() {
		return this.ticketId;
	}

	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}

	public String getTicketDesc() {
		return this.ticketDesc;
	}

	public void setTicketDesc(String ticketDesc) {
		this.ticketDesc = ticketDesc;
	}

	public int getTicketOpprId() {
		return this.ticketOpprId;
	}

	public void setTicketOpprId(int ticketOpprId) {
		this.ticketOpprId = ticketOpprId;
	}

	public int getTicketOwnerId() {
		return this.ticketOwnerId;
	}

	public void setTicketOwnerId(int ticketOwnerId) {
		this.ticketOwnerId = ticketOwnerId;
	}

	public SalesOppr getSalesOppr() {
		return salesOppr;
	}

	public void setSalesOppr(SalesOppr salesOppr) {
		this.salesOppr = salesOppr;
	}

}