package com.example.springbootdemo.service.strategy;

/**
 * @description：
 * @author: zhangxianglong
 * @date: 2022/6/15
 */
public class StrategyB implements Strategy {
    @Override
    public void show() {
        System.out.println("执行了B策略");
    }
}
