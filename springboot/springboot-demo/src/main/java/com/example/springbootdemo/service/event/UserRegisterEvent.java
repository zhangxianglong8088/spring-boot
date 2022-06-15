package com.example.springbootdemo.service.event;

import org.springframework.context.ApplicationEvent;

/**
 * @description：
 * @author: zhangxianglong
 * @date: 2022/3/10
 */
public class UserRegisterEvent extends ApplicationEvent {

    public UserRegisterEvent(String name) { //name 即 source
        super(name);
    }
}
