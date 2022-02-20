package com.example.springbootdemo.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.concurrent.Future;

/**
 * @description：
 * @author: zhangxianglong
 * @date: 2022/2/18
 */
@Service
public class Task {

    public static Random random = new Random();

    @Async
    public void doTaskOne() throws Exception {
        System.out.println("开始做任务一");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        System.out.println("完成任务一，耗时：" + (end - start) + "毫秒");
    }

    @Async
    public void doTaskTwo() throws Exception {
        System.out.println("开始做任务二");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        System.out.println("完成任务二，耗时：" + (end - start) + "毫秒");
    }

    @Async
    public void doTaskThree() throws Exception {
        System.out.println("开始做任务三");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        System.out.println("完成任务三，耗时：" + (end - start) + "毫秒");
    }

    @Async
    public Future<String> doTaskFour() throws Exception {
        System.out.println("开始做任务四");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        System.out.println("完成任务四，耗时：" + (end - start) + "毫秒");
        return new AsyncResult<String>("");
    }

    /**
     * @throws Exception
     * @Asyn 自定义线程池
     */
    @Async("threadPool")
    public void doTaskFive() throws Exception {
        System.out.println("开始做任务五");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        System.out.println("完成任务五，耗时：" + (end - start) + "毫秒");
    }


    /**
     * @throws Exception
     * @Asyn 自定义线程池
     */
    @Async("threadPool")
    public Future<String> doTaskSix() throws Exception {
        System.out.println("开始做任务6");
        long start = System.currentTimeMillis();
        Thread.sleep(10000);
        long end = System.currentTimeMillis();
        System.out.println("完成任务6，耗时：" + (end - start) + "毫秒");
        return new AsyncResult<String>("");
    }
}
