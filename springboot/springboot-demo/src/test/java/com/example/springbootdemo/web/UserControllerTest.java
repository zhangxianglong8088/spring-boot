package com.example.springbootdemo.web;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;


/**
 * @description：
 * @author: zhangxianglong
 * @date: 2022/2/11
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {

    private MockMvc mvc;

    @Before
    public void setUp() throws Exception {
        System.out.println("Before方法执行了");
        mvc = MockMvcBuilders.standaloneSetup(new UserController()).build();
    }


    @After
    public void after() throws Exception {
        System.out.println("after方法执行了");
    }

    /**
     * Springboot单元测试测试一个http接口
     *
     * @throws Exception
     */
    @Test
    public void test() throws Exception {

        mvc.perform(MockMvcRequestBuilders.get("/test").accept(MediaType.APPLICATION_JSON))
                .andExpect(content().string(equalTo("test")));

    }

}