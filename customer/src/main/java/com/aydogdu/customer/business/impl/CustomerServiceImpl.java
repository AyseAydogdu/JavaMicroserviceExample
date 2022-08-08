package com.aydogdu.customer.business.impl;

import com.aydogdu.customer.business.CustomerService;
import com.aydogdu.customer.business.dto.CustomerDto;
import com.aydogdu.customer.data.entity.Customer;
import com.aydogdu.customer.data.repository.CustomerRepository;
import com.aydogdu.customer.exception.CustomerAlreadyExistException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Author Ayse Aydogdu
 * @Date 7/20/2022 10:36 PM
 */
@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    ModelMapper modelMapper;
    public List<CustomerDto> findAllCustomers() {
       return entitytoDtoList(customerRepository.findAll());
    }

    public CustomerDto entityToDto(Customer customer){
        return modelMapper.map(customer,CustomerDto.class);
    }
    public Customer dtoToEntity(CustomerDto customerDto){
        return modelMapper.map(customerDto,Customer.class);
    }
    public List<CustomerDto> entitytoDtoList(List<Customer> customers){
        List<CustomerDto> customerDtos = null;
        for (Customer customer:customers) {
            customerDtos.add(entityToDto(customer));
        }
        return customerDtos;
    }

    public CustomerDto saveCustomer(CustomerDto customerDto) {
        if(customerRepository.findByIdNumber(customerDto.getIdNumber())== null)
        {
            return entityToDto(customerRepository.save(dtoToEntity(customerDto)));
        }
        else {
            throw new CustomerAlreadyExistException("This customer already exist");
        }

    }
    public String deleteCustomerByIdNumber(Long idNumber) {

        if (customerRepository.findByIdNumber(idNumber) == null) {

            throw new EmptyResultDataAccessException(0);
        } else {
            customerRepository.deleteByIdNumber(idNumber);
            return "Deleted with idNumber :\t" + idNumber;
        }

    }

}
