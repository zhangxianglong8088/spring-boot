package com.example.springbootdemo.service.observe.spring;

import org.springframework.context.ApplicationEvent;

/**
 * @description：
 * @author: zhangxianglong
 * @date: 2022/6/15
 */
public class MyEvent extends ApplicationEvent {
    public MyEvent(Object source) {
        super(source);
        System.out.println("my Event");
    }
}
