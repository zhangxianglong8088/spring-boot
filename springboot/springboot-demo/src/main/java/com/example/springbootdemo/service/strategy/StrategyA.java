package com.example.springbootdemo.service.strategy;

/**
 * @description：
 * @author: zhangxianglong
 * @date: 2022/6/15
 */
public class StrategyA implements Strategy {
    @Override
    public void show() {
        System.out.println("执行了A策略算法");
    }
}
