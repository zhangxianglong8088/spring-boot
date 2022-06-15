package com.example.springbootdemo.service.proxy;

import java.lang.reflect.Proxy;

/**
 * @description：
 * @author: zhangxianglong
 * @date: 2022/5/6
 */
public class TestProxy {

    public static void main(String[] args) throws Exception {

        System.getProperties().put("jdk.proxy.ProxyGenerator.saveGeneratedFiles", "true");

        Animal cat = new Cat();
        /**
         * loader: 用哪个类加载器去加载代理对象
         * interfaces:动态代理类需要实现的接口
         * h:动态代理方法在执行时，会调用h里面的invoke方法去执行
         */
        Animal animal = (Animal) Proxy.newProxyInstance(Animal.class.getClassLoader(), Cat.class.getInterfaces(), new AnimalInvacationHandler(cat));

        animal.doWhat();

        animal.play();
    }
}
