package com.bookstore.restapi.controller;

import com.bookstore.restapi.domain.CustomerDto;
import com.bookstore.restapi.domain.request.CustomerRegisterDto;
import com.bookstore.restapi.domain.response.ResponseWrapper;
import com.bookstore.restapi.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("/register")
    public ResponseEntity<ResponseWrapper<Boolean>> registerCustomer(@Valid @RequestBody CustomerRegisterDto request) {
        return ResponseEntity.ok(customerService.registerCustomer(request));
    }

    @GetMapping
    public ResponseEntity<ResponseWrapper<List<CustomerDto>>> getAllCustomers() {
        return ResponseEntity.ok(customerService.getAllCustomers());
    }
}
