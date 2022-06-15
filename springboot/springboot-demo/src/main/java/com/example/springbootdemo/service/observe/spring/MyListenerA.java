package com.example.springbootdemo.service.observe.spring;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @description：
 * @author: zhangxianglong
 * @date: 2022/6/15
 */
@Component
public class MyListenerA implements ApplicationListener<MyEvent> {

    @Override
    public void onApplicationEvent(MyEvent myEvent) {
        System.out.println("ListenerA received");
        String event = (String) myEvent.getSource();
        System.out.println("ListenerA received event" + event);
    }
}
