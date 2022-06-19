package com.example.springbootdemo.config;

import com.example.springbootdemo.ZookeeperWatcher;
import org.apache.zookeeper.ZooKeeper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description：
 * @author: zhangxianglong
 * @date: 2022/6/19
 */
@Configuration
public class SpringConfig {

    @Value("127.0.0.1:2181")
    private String zookeeperAddress;


    @Bean
    public ZooKeeper initZookeeper() throws Exception {
        return new ZooKeeper(zookeeperAddress, 60000, new ZookeeperWatcher());
    }
}
