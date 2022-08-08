package com.aydogdu.customer.controller;

import com.aydogdu.customer.business.CustomerService;
import com.aydogdu.customer.business.dto.CustomerDto;
import com.aydogdu.customer.business.impl.CustomerServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author Ayse Aydogdu
 * @Date 7/20/2022 10:38 PM
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerServiceImpl customerServiceImpl;

    // https://locallhost:8090/customer
    @GetMapping
    public ResponseEntity<List<CustomerDto>> findAllCustomers(){
        return ResponseEntity.ok(customerServiceImpl.findAllCustomers());
    }

    // https://locallhost:8090/customer
    @PostMapping()
    public ResponseEntity<CustomerDto> saveCustomer(@RequestBody CustomerDto customerDto)
    {
        return ResponseEntity.ok(customerServiceImpl.saveCustomer(customerDto));
    }

    // https://locallhost:8090/customer/idNumber
    @DeleteMapping("{idNumber}")
    public ResponseEntity<String> deleteCustomerByIdNumber(@PathVariable Long idNumber)
    {
        return ResponseEntity.ok(customerServiceImpl.deleteCustomerByIdNumber(idNumber));
    }

}
