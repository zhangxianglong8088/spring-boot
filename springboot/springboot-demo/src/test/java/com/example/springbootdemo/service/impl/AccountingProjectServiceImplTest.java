package com.example.springbootdemo.service.impl;

import com.example.springbootdemo.dao.domain.AccountInfo;
import com.example.springbootdemo.service.AccountingInfoService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;


/**
 * @description：
 * @author: zhangxianglong
 * @date: 2022/2/20
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class AccountingProjectServiceImplTest {

    @Resource
    private AccountingInfoService accountingProjectService;

    /**
     * Springboot单元测试测试一个http接口
     *
     * @throws Exception
     */
    @Test
    public void test() throws Exception {

        AccountInfo accountInfo = accountingProjectService.getById(1);
        log.info("AccountInfo" + accountInfo);
    }
}