package com.example.springbootdemo.service.es.repository;

import com.example.springbootdemo.service.es.domain.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @description：
 * @author: zhangxianglong
 * @date: 2022/7/19
 */
public interface UserRepository extends ElasticsearchRepository<User, String> {
}
