package com.example.springbootdemo.service.proxy;

/**
 * @description：
 * @author: zhangxianglong
 * @date: 2022/5/6
 */
public class Cat implements Animal {

    @Override
    public void doWhat() throws Exception {
        System.out.println("cat 喵喵。。。。。");
    }

    @Override
    public void play() throws Exception {
        System.out.println("cat play。。。。。");
    }
}
