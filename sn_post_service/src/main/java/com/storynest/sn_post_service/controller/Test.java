package com.storynest.sn_post_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("post")
@RestController
public class Test {

    @GetMapping("/post1")
    public String getMap() {
        return "Hey! gateway is working fine for post service.";
    }
}
