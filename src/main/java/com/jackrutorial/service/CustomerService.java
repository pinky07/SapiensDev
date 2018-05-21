package com.jackrutorial.service;

import java.util.List;

import com.jackrutorial.model.Customer;

public interface CustomerService {
 
 public List listAllCustomers();
 
 public void saveOrUpdate(Customer customer);
 
 public Customer findCustomerById(int id);
 
 public void deleteCustomer(int id);
}