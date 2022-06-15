package com.example.springbootdemo.service.strategy;

/**
 * @description：
 * @author: zhangxianglong
 * @date: 2022/6/15
 */
public class Clinent {

    public static void main(String[] args) {
        StrategyA strategyA = new StrategyA();
        StragegyContext context = new StragegyContext(strategyA);
        context.getStrategy().show();
    }
}
