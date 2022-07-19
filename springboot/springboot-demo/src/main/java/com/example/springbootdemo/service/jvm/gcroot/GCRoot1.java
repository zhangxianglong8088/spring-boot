package com.example.springbootdemo.service.jvm.gcroot;

/**
 * @description：
 * @author: zhangxianglong
 * @date: 2022/7/15
 */
public class GCRoot1 {

    public static void main(String[] args) {

        testGcRoot1();

        System.out.println("执行第二次GC");
        System.gc();


    }

    static void testGcRoot1() {
        GCRoot1 gcRoot1 = new GCRoot1();
        System.out.println("执行第一次GC");
        System.gc();
    }
}
