package com.example.springbootdemo.service.strategy;

/**
 * @description：
 * @author: zhangxianglong
 * @date: 2022/6/15
 */
public class StragegyContext {

    Strategy strategy;

    public StragegyContext(Strategy strategy) {
        this.strategy = strategy;
    }

    public Strategy getStrategy() {
        return strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }
}
