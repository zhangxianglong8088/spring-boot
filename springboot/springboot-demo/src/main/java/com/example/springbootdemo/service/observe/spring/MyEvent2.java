package com.example.springbootdemo.service.observe.spring;

import org.springframework.context.ApplicationEvent;

/**
 * @description：
 * @author: zhangxianglong
 * @date: 2022/6/15
 */
public class MyEvent2 extends ApplicationEvent {
    public MyEvent2(Object source) {
        super(source);
        System.out.println("my Event2");
    }
}
