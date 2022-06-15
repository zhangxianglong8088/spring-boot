package com.example.springbootdemo.service.observe.jdk;

import java.util.ArrayList;
import java.util.List;

/**
 * @description：被观察者
 * @author: zhangxianglong
 * @date: 2022/6/15
 */
public abstract class Subject {

    List<Observer> obs = new ArrayList<>();

    public void addObserver(Observer obs) {
        this.obs.add(obs);
    }

    public void delObserver(Observer obs) {
        this.obs.remove(obs);
    }

    protected void notifyObserver() {
        for (Observer o : obs) {
            o.update();
        }
    }
    public abstract void doSomething();

}
