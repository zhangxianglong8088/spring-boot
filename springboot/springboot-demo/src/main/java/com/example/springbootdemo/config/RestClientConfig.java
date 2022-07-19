package com.example.springbootdemo.config;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;

/**
 * @description： 在Spring data 2.x ~ 3.x 时，推荐使用ElasticTemplate来操作ES，ElasticTemplate底层调用的是TransportClient，
 * 使用的是ES的TCP端口9300，但是TransportClient在ES 6.x ~ 7.x 时就已经不推荐使用，在 8.x 已经废弃。所以在最新版的Spring Data 4.x中，
 * 已经弃用ElasticTemplate，推荐使用RestHighLevelClient（高等级REST客户端）和ElasticsearchRepository接口来操作ES，使用的是ES的Web端口9200，类似于Kibana。
 * <p>
 * RestHighLevelClient：用来实现ES的复杂检索。
 * ElasticsearchRepository：用来实现ES的常规操作
 * @author: zhangxianglong
 * @date: 2022/7/19
 */
@Configuration
public class RestClientConfig extends AbstractElasticsearchConfiguration {

    @Override
    @Bean
    public RestHighLevelClient elasticsearchClient() {

        // 定义ES客户端对象：ip + port
        final ClientConfiguration clientConfiguration = ClientConfiguration.builder().connectedTo("localhost:9200").build();

        return RestClients.create(clientConfiguration).rest();
    }
}
