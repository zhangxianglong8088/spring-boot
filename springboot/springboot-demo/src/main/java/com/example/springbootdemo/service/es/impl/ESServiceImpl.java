package com.example.springbootdemo.service.es.impl;

import com.example.springbootdemo.service.es.ESService;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @description：
 * @author: zhangxianglong
 * @date: 2022/7/19
 */
@Service
public class ESServiceImpl implements ESService {
    @Resource
    private RestHighLevelClient restHighLevelClient;

    @Override
    public void saveDocument() throws IOException {
        // 构建索引请求 传入参数为：index名，type名，自定义该Document的_id
        IndexRequest indexRequest = new IndexRequest("postilhub", "user", "1");

        // 传入参数为：新增Document的数据，数据类型
        indexRequest.source("{\"id\":\"1\",\"username\":\"小明\",\"age\":19}", XContentType.JSON);

        // 执行新增 RequestOptions.DEFAULT为枚举类型，默认即可
        IndexResponse indexResponse = restHighLevelClient.index(indexRequest, RequestOptions.DEFAULT);

        // 查看操作是否成功
        System.out.println(indexResponse.status());

    }
}
