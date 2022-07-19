package com.example.springbootdemo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @description：
 * @author: zhangxianglong
 * @date: 2022/6/27
 */
public class ThreadPoolExecutorTest {
    public static void main(String[] args) {
//        int corePoolSize,
//        int maximumPoolSize,
//        long keepAliveTime,
//        TimeUnit unit,
//        BlockingQueue<Runnable> workQueue
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 100, TimeUnit.MINUTES, new ArrayBlockingQueue<>(10));

        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("任务1执行----");
            }
        };

        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                System.out.println("任务2执行----");
            }
        };

        executor.submit(r1);
        executor.submit(r2);
    }
}
