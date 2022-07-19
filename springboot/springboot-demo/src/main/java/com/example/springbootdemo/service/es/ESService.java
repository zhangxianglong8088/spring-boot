package com.example.springbootdemo.service.es;

import java.io.IOException;

/**
 * @description：
 * @author: zhangxianglong
 * @date: 2022/7/19
 */
public interface ESService {
    /**
     * ES创建一个文档
     *
     * @throws IOException
     */
    public void saveDocument() throws IOException;
}

