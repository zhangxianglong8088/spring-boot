package com.example.springbootdemo.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @description：
 * @author: zhangxianglong
 * @date: 2022/4/13
 */
public class DateTest {
    static Integer checkDate(Date startTime, Date endTime) {

        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:00:00");
        java.util.Date now = new java.util.Date();
        String s = sdf1.format(now);

        try {
            long currentTime = sdf1.parse(s).getTime();

            //已失效
            if (endTime.getTime() < currentTime) {
                return 10;
            }

            //生效中
            if (startTime.getTime() <= currentTime && endTime.getTime() >= currentTime) {
                return 20;
            }

            //待生效
            if (startTime.getTime() > currentTime) {
                return 30;
            }

        } catch (ParseException e) {
        }
        return null;
    }
}
