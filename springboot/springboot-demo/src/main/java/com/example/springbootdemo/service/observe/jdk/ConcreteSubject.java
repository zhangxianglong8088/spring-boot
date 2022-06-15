package com.example.springbootdemo.service.observe.jdk;

/**
 * @description：
 * @author: zhangxianglong
 * @date: 2022/6/15
 */
public class ConcreteSubject extends Subject {

    @Override
    public void doSomething() {
        System.out.println("被观察者事件发生改变");
        this.notifyObserver();
    }
}
