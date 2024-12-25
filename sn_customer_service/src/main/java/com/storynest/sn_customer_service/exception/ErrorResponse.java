package com.storynest.sn_customer_service.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@Getter
public class ErrorResponse {

    private int statusCode;
    private Date timestamp;
    private String message;
    private String description;


}
