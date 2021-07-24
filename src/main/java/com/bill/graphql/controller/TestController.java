package com.bill.graphql.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Bill.Lin on 2021/7/25
 */

@RestController
public class TestController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello this is test controller";
    }
}
