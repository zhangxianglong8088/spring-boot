//package com.example.springbootdemo.service.spi.impl;
//
//import com.example.springbootdemo.service.spi.TestSpiService;
//
//import java.util.ServiceLoader;
//
///**
// * @description：
// * @author: zhangxianglong
// * @date: 2022/6/13
// */
//public class TestSPI {
//
//    public static void main(String[] args) {
//        ServiceLoader<TestSpiService> shouts = ServiceLoader.load(TestSpiService.class);
//        for (TestSpiService s : shouts) {
//            s.hello();
//        }
//    }
//}
