package com.storynest.sn_customer_service.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping
@RestController
public class Test {

    @GetMapping("/customer")
    public String getMap() {
        return "Hey! gateway is working fine for customer.";
    }
}
