package com.example.eurekaconsumer.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @description：
 * @author: zhangxianglong
 * @date: 2022/2/23
 */
@Service
public class ConsumerService {

    @Resource
    RestTemplate restTemplate;

    /**
     * 测试hysterix 超时fallback 服务降级
     *
     * @return
     */
    @HystrixCommand(fallbackMethod = "fallback")
    public String consumer() {
        return restTemplate.getForObject("http://eureka-client/dc", String.class);
    }

    public String fallback() {
        System.out.println("执行fallback逻辑");
        return "fallback";
    }
}
