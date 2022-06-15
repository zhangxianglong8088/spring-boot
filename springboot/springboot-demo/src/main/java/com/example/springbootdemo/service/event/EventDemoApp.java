package com.example.springbootdemo.service.event;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @description：
 * @author: zhangxianglong
 * @date: 2022/3/10
 */
@RestController
public class EventDemoApp {

    @Resource
    private UserService userService;

    @RequestMapping("/register")
    public String register() {
        userService.register("kirito");
        return "success";
    }
}
