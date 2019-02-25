package com.transaction.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TicketAdd {

	@Autowired
	UtilClass utilClass;

	public String ticketOwner = "0";
	public String ticketOpprId = "0";

	TicketAdd() {

	}

	TicketAdd(String ticketOwner, String ticketOpprId) {
		this.ticketOwner = ticketOwner;
	}

	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public void addFields() {

		System.out.println("ticketOwner====" + ticketOwner);
		System.out.println("ticketOpprId====" + ticketOpprId);
	}
}
