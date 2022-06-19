package com.example.springbootdemo.utils.gc;

import java.lang.instrument.Instrumentation;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @description：
 * @author: zhangxianglong
 * @date: 2022/6/19
 */
public class Agetn {

    public static void test() {
        System.out.println("this is my agent：");
        Executors.newScheduledThreadPool(1).scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                JvmStack.printMemoryInfo();
                JvmStack.printGCInfo();
                System.out.println("===================================================================================================");
            }
        }, 0, 5000, TimeUnit.MILLISECONDS);
    }

    public static void main(String[] args) {
        test();
    }
}
