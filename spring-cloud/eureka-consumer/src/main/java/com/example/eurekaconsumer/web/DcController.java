package com.example.eurekaconsumer.web;

import com.example.eurekaconsumer.service.ConsumerService;
import com.example.eurekaconsumer.service.DcClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @description：
 * @author: zhangxianglong
 * @date: 2022/2/21
 */
@RestController
public class DcController {

    @Resource
    LoadBalancerClient loadBalancerClient;
    @Autowired
    RestTemplate restTemplate;
    @Resource
    private ConsumerService consumerService;

    @Resource
    DcClient dcClient;

    @GetMapping("/consumer")
    public String dc() {
        ServiceInstance serviceInstance = loadBalancerClient.choose("eureka-client");
        String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/dc";
        System.out.println(url);
        return restTemplate.getForObject(url, String.class);
    }

    @GetMapping("/consumer/ribbon")
    public String dcByRibbon() {
        //因为Spring Cloud Ribbon有一个拦截器，它能够在这里进行实际调用的时候，自动的去选取服务实例，
        // 并将实际要请求的IP地址和端口替换这里的服务名，从而完成服务接口的调用。
        return restTemplate.getForObject("http://eureka-client/dc", String.class);
    }

    @GetMapping("/consumer/feign")
    public String dcByFeign() {
        return dcClient.consumer();
    }

    /**
     * 测试hystrix超时
     * @return
     */
    @GetMapping("/consumer/hystrix")
    public String hysteria() {
        return consumerService.consumer();
    }
}
