package com.example.springbootdemo.web;

import com.example.springbootdemo.dao.AccountInfoDao;
import com.example.springbootdemo.dao.domain.AccountInfo;
import com.example.springbootdemo.dao.mapper.AccountInfoMapper;
import com.example.springbootdemo.service.AccountingInfoService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @description：
 * @author: zhangxianglong
 * @date: 2022/2/10
 */
@RestController
@Slf4j
public class UserController {

    @Resource
    private AccountInfoMapper accountInfoMapper;
    @Resource
    private AccountingInfoService accountingInfoService;

    @Value("${name}")
    private String name;

    @GetMapping("test")
    @ApiOperation(value = "获取用户列表", notes = "")
    public String test() {
        log.info("test用户列表 info");
        log.error("test用户列表 error");
        log.debug("test用户列表  debug");

        System.out.println("测试名称" + name);
        return "test";
    }

    @GetMapping("hello")
    public String hello() {
        System.out.println(name);
        int i = 1 / 0;
        return "hello";
    }

    @GetMapping("accounting")
    public String accounting() {
        AccountInfo accountingProject = accountInfoMapper.selectByPrimaryKey(1);
        return "hello";
    }

    /**
     * 测试Spring事物
     */
    @GetMapping("save")
    public void save() {

        AccountInfo accountInfo = new AccountInfo();
        accountInfo.setAccountId("123L");
        accountInfo.setUserId(123L);
        accountInfo.setAccountBalance(BigDecimal.ONE);
        accountingInfoService.save(accountInfo);

    }
}
