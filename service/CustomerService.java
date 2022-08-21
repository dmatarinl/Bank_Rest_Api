package io.bankapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import io.bankapp.dao.CustomerRepository;
import io.bankapp.model.Customer;

    /*Comment Section */
//Class CustomerService has all the functions related to manipulating the creation, 
//checking all the information of the costumer and the removal of the costumer.

@Service
public class CustomerService {
	@Autowired
	private CustomerRepository customerRepository;

	public void createCustomer(Customer customer) {

		customerRepository.save(customer);

	}

	public Customer getCustomerInfo(int acctID) {

		return customerRepository.findById(acctID).orElse(null);

	}

	public void deleteCustomer(int acctID) {

		customerRepository.deleteById(acctID);

	}

}
