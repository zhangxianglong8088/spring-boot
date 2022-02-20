package com.example.springbootdemo.web;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @description：SpringBoot中定时任务
 * （1）、方法上面加：@Scheduled(cron="")
 * （2）、Application启动类加@EnableScheduling注解
 * @author: zhangxianglong
 * @date: 2022/2/18
 */
@Component
public class ScheduledTasks {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");


//    @Scheduled(fixedRate = 5000)
//    public void reportCurrentTime() {
//        System.out.println("现在时间：" + dateFormat.format(new Date()));
//    }

}
