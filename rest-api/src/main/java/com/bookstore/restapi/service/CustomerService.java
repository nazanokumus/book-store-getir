package com.bookstore.restapi.service;

import com.bookstore.restapi.domain.CustomerDto;
import com.bookstore.restapi.domain.request.CustomerRegisterDto;
import com.bookstore.restapi.domain.response.ResponseWrapper;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface CustomerService extends UserDetailsService {

    ResponseWrapper<Boolean> registerCustomer(CustomerRegisterDto request);

    ResponseWrapper<List<CustomerDto>> getAllCustomers();
}
