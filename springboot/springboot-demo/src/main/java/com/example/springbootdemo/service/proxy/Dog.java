package com.example.springbootdemo.service.proxy;

/**
 * @description：
 * @author: zhangxianglong
 * @date: 2022/5/6
 */
public class Dog implements Animal {

    @Override
    public void doWhat() throws Exception {
        System.out.println("dog 汪汪汪。。。。。");
    }

    @Override
    public void play() throws Exception {
        System.out.println("dog play。。。。。");
    }
}
