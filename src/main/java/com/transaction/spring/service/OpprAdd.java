package com.transaction.spring.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import com.transaction.spring.model.Customer;
import com.transaction.spring.model.CustomerContact;
import com.transaction.spring.model.SalesOppr;
import com.transaction.spring.repo.ContactRepo;
import com.transaction.spring.repo.CustomerRepo;
import com.transaction.spring.repo.OpprRepo;

@Service
public class OpprAdd {
	@Autowired
	ContactRepo contactRepo;

	@Autowired
	CustomerRepo customerRepo;

	@Autowired
	OpprRepo opprRepo;

	@Autowired
	TicketAdd ticketAdd;

	@Autowired
	UtilClass utilClass;

	public ModelAndView getModelAndView(Model model, ModelAndView modelAndView) {
		modelAndView.addObject("SalesOppr", new SalesOppr());
		modelAndView.setViewName("enquiry-add");
		return modelAndView;

	}

	public ModelAndView postModelAndView(Model model, SalesOppr SalesOppr, ModelAndView modelAndView) {

		addOppr(SalesOppr);

		modelAndView.addObject("SalesOppr", SalesOppr);
		modelAndView.setViewName("enquiry-add");
		return modelAndView;
	}

	private void sendEmailSms(SalesOppr SalesOppr) {
		System.err.println("123");
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void addOppr(SalesOppr SalesOppr) {
		Customer Customer = new Customer();
		Customer.setCustomerName(SalesOppr.getCustomerName());

		customerRepo.save(Customer);

		CustomerContact CustomerContact = new CustomerContact();
		CustomerContact.setContactFname(SalesOppr.getContactFname());
		CustomerContact.setContactLname(SalesOppr.getContactLname());
		CustomerContact.setContactCustomerId(Customer.getCustomerId());

		contactRepo.save(CustomerContact);

		SalesOppr.setOpprTitle("New Oppr");
		SalesOppr.setOpprDate(new Date());
		SalesOppr.setOpprDesc("Hello");
		SalesOppr.setOpprCustomerId(Customer.getCustomerId());
		SalesOppr.setOpprContactId(CustomerContact.getContactId());
		opprRepo.save(SalesOppr);

		sendEmailSms(SalesOppr);
		ticketAdd.ticketOwner = "1";
		ticketAdd.ticketOpprId = String.valueOf(SalesOppr.getOpprId());
		ticketAdd.addFields();

	}

}
