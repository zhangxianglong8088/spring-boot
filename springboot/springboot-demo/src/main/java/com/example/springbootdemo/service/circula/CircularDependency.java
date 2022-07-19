package com.example.springbootdemo.service.circula;

import org.springframework.context.ApplicationContext;

import javax.annotation.Resource;

/**
 * @description：模拟Spring循环依赖
 * @author: zhangxianglong
 * @date: 2022/5/8
 */
public class CircularDependency {
    @Resource
    static private ApplicationContext applicationContext;

    static class ClazzA {

        private ClazzB b = new ClazzB();

    }

    static class ClazzB {

        private ClazzA a = new ClazzA();

    }

}
