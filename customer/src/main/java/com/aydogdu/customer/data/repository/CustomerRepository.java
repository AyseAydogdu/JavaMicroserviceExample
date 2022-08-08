package com.aydogdu.customer.data.repository;

import com.aydogdu.customer.data.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author Ayse Aydogdu
 * @Date 7/20/2022 10:40 PM
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
    Customer findByIdNumber(Long idNumber);

    Customer deleteByIdNumber(Long idNumber);
}
