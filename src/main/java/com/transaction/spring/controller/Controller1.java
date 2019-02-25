package com.transaction.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.transaction.spring.model.SalesOppr;
import com.transaction.spring.service.OpprAdd;

@RestController
public class Controller1 {
	
	@Autowired
	OpprAdd enquiryAdd;
	
	@GetMapping("/")
	public ModelAndView index(ModelAndView modelAndView) {
		modelAndView.setViewName("index");
		return modelAndView;
		
	}
	
	@GetMapping("/enquiry-add")
	public ModelAndView enquiryGetModelAndView(Model model,ModelAndView modelAndView) {
		return enquiryAdd.getModelAndView(model,modelAndView);
		
	}
	@PostMapping("/enquiry-add")
	public ModelAndView enquiryPetModelAndView(Model model,@ModelAttribute ("salesOppr") SalesOppr salesOppr, ModelAndView modelAndView) {
		System.out.println("coming");
		return enquiryAdd.postModelAndView(model,salesOppr,modelAndView);
		
	}
	

}
