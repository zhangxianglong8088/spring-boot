package com.example.springbootdemo.service.observe.spring;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @description：
 * @author: zhangxianglong
 * @date: 2022/6/15
 */
@Component
public class MyListenerB implements ApplicationListener<MyEvent> {
    @Override
    public void onApplicationEvent(MyEvent myEvent) {
        System.out.println("ListenerB received");
        String event = (String) myEvent.getSource();
        System.out.println("ListenerB received event" + event);
    }
}
