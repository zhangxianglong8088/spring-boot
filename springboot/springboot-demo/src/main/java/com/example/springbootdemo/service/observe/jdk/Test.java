package com.example.springbootdemo.service.observe.jdk;

import org.checkerframework.checker.units.qual.C;

import java.util.ArrayList;
import java.util.List;

/**
 * @description：
 * @author: zhangxianglong
 * @date: 2022/6/15
 */
public class Test {

    public static void main(String[] args) {
        List<Observer> list = new ArrayList<>();

        ConcreteSubject concreteSubject = new ConcreteSubject();

        ConcreteObserver1 concreteObserver1 = new ConcreteObserver1();
        ConcreteObserver2 concreteObserver2 = new ConcreteObserver2();

        //被观察者添加观察者对象
        concreteSubject.addObserver(concreteObserver1);
        concreteSubject.addObserver(concreteObserver2);

        //被观察者调用
        concreteSubject.doSomething();
    }
}
