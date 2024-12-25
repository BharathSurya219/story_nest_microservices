package com.storynest.sn_customer_service.exception;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String format) {
        super(format);
    }
}
