package com.aydogdu.customer.business.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

/**
 * @Author Ayse Aydogdu
 * @Date 7/20/2022 10:39 PM
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CustomerDto {

    Long id;

    Long idNumber;

    String name;

    Integer salary;
    String mail;
}
