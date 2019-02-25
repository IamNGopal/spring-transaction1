package com.transaction.spring.service;

import org.springframework.stereotype.Service;

@Service
public class UtilClass {

	public String ticketOwner = "0";
	public String ticketOpprId = "0";

	public String getTicketOwner() {
		return ticketOwner;
	}

	public void setTicketOwner(String ticketOwner) {
		this.ticketOwner = ticketOwner;
	}

	public String getTicketOpprId() {
		return ticketOpprId;
	}

	public void setTicketOpprId(String ticketOpprId) {
		this.ticketOpprId = ticketOpprId;
	}

}
