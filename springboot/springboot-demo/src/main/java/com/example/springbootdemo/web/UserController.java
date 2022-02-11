package com.example.springbootdemo.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description：
 * @author: zhangxianglong
 * @date: 2022/2/10
 */
@RestController
public class UserController {

    @Value("${name}")
    private String name;

    @GetMapping("test")
    public String test() {
        System.out.println(name);
        return "test";
    }

    @PostMapping("hello")
    public String hello() {
        System.out.println(name);
        return "hello";
    }
}
