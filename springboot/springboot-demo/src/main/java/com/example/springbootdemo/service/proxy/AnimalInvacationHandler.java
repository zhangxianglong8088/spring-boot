package com.example.springbootdemo.service.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @description：
 * @author: zhangxianglong
 * @date: 2022/5/6
 */
public class AnimalInvacationHandler implements InvocationHandler {

    private final Animal animal;

    public AnimalInvacationHandler(Animal animal) {
        this.animal = animal;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("before......");

        method.invoke(animal,args);

        System.out.println("after.......");

        return null;
    }
}
