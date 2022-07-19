package com.example.springbootdemo.web;

import com.example.springbootdemo.dao.domain.AccountInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @description：
 * @author: zhangxianglong
 * @date: 2022/7/4
 */
@RestController
public class TestDeadCycle {

    /**
     * 测试Spring事物
     */
    @GetMapping("dead/cycle")
    public void save() {

        while (true) {
            System.out.println("hello world");
        }

    }


    /**
     * 测试Spring事物
     */
    @GetMapping("dead/lock")
    public void aaaa() {
        Object lockA = new Object(); // 创建锁 A
        Object lockB = new Object(); // 创建锁 B

        // 创建线程 1
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                // 先获取锁 A
                synchronized (lockA) {
                    System.out.println("线程 1:获取到锁 A!");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    // 尝试获取锁 B
                    System.out.println("线程 1:等待获取 B...");
                    synchronized (lockB) {
                        System.out.println("线程 1:获取到锁 B!");
                    }
                }
            }
        });
        t1.start(); // 运行线程

        // 创建线程 2
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                // 先获取锁 B
                synchronized (lockB) {
                    System.out.println("线程 2:获取到锁 B!");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    // 尝试获取锁 A
                    System.out.println("线程 2:等待获取 A...");
                    synchronized (lockA) {
                        System.out.println("线程 2:获取到锁 A!");
                    }
                }
            }
        });
        t2.start(); // 运行线程
    }
}
