package com.aydogdu.customer.exception;

/**
 * @Author Ayse Aydogdu
 * @Date 7/21/2022 2:34 PM
 */
public class CustomerAlreadyExistException extends RuntimeException{
    public CustomerAlreadyExistException(String message){
    super(message);
    }
}
