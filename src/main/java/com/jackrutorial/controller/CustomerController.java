package com.jackrutorial.controller;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.jackrutorial.model.Customer;
import com.jackrutorial.service.CustomerService;
import org.apache.log4j.Logger;
@Controller
@RequestMapping(value="/customer")

public class CustomerController {
	private static final Logger logger = Logger.getLogger(CustomerController.class);

 @Autowired
 CustomerService customerService;
 
 @SuppressWarnings("unchecked")
@RequestMapping(value="/list", method=RequestMethod.GET)
 public ModelAndView list(){
	 ModelAndView model = new ModelAndView("customer/list");
	 customerService.listAllCustomers();
	 List userList = customerService.listAllCustomers();
	 
	 List<Customer> slist= (List<Customer>) userList.stream().sorted
			 (Comparator.comparing(Customer::getLastname)).collect(Collectors.toList());
	  model.addObject("list", slist);
	  
	  	return model;
	}
 
 
 @RequestMapping(value="/add", method=RequestMethod.GET)
 public ModelAndView add(){
  ModelAndView model = new ModelAndView("customer/form");
  Customer customer = new Customer();
  model.addObject("customerForm", customer);
  
  return model;
 }
 
 @RequestMapping(value="/save", method=RequestMethod.POST)
 public ModelAndView save(@Valid @ModelAttribute("customerForm") Customer customer,BindingResult result){
//	 if (result.hasErrors()) {
//		 return new ModelAndView("redirect:/customer/form");
//			
//		} else {
			customerService.saveOrUpdate(customer);
			  return new ModelAndView("redirect:/customer/list");
		
//		}
  
  

 }
 @RequestMapping(value="/update/{id}", method=RequestMethod.GET)
 public ModelAndView update(@PathVariable("id") int id){
  ModelAndView model = new ModelAndView("customer/form");
  Customer customer = customerService.findCustomerById(id);
  model.addObject("customerForm", customer);
  
  return model;
 }
 @RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
 public ModelAndView delete(@PathVariable("id") int id){
  customerService.deleteCustomer(id);
  return new ModelAndView("redirect:/customer/list");
 }
}
