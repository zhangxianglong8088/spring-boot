package com.example.springbootdemo.service.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

/**
 * @description：
 * @author: zhangxianglong
 * @date: 2022/3/10
 */
@Service
public class EmailService implements ApplicationListener<UserRegisterEvent> {


    @Override
    public void onApplicationEvent(UserRegisterEvent event) {
        System.out.println("邮件服务接到通知，给" + event.getSource() + "发送邮件...");
    }
}
