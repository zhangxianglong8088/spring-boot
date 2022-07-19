package com.example.springbootdemo.service.es.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

/**
 * @description：
 * @author: zhangxianglong
 * @date: 2022/7/19
 */
@Data
@Document(indexName = "postilhub")
/**
 * @Document：构建指定index和type，并能够自动将该类构建的Bean通过JSON序列化成Document存入ES的该index的type中
 */
public class User {

    /**
     * @id： 创建 Document的同时将Bean中的id赋值给 _id。
     */
    @Id
    @Field(type = FieldType.Keyword)
    private String id;

    /**
     * 构建指定mapping，给某些必要的字段设置分词器
     */
    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String username;

    @Field(type = FieldType.Integer)
    private Integer age;

    @Field(type = FieldType.Date)
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date birth;

    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String intro;
}
