package com.example.springbootdemo.service.observe.jdk;

/**
 * @description：
 * @author: zhangxianglong
 * @date: 2022/6/15
 */
public class ConcreteObserver1 implements Observer {

    @Override
    public void update() {

        System.out.println("观察者1执行");

    }
}
