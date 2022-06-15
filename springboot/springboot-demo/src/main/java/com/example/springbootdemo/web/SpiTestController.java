//package com.example.springbootdemo.web;
//
//import com.example.springbootdemo.service.spi.TestSpiService;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.annotation.Resource;
//
///**
// * @description：
// * @author: zhangxianglong
// * @date: 2022/2/10
// */
//@RestController
//@Slf4j
//public class SpiTestController {
//
//    @Resource
//    TestSpiService testSpiService;
//
//
//    /**
//     * 测试spi
//     */
//    @GetMapping("spi")
//    public void spi() {
//
//        testSpiService.hello();
//
//    }
//}
