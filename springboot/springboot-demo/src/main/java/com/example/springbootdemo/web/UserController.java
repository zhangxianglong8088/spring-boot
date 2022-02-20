package com.example.springbootdemo.web;

import com.example.springbootdemo.dao.domain.AccountInfo;
import com.example.springbootdemo.dao.mapper.AccountInfoMapper;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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

    @PostMapping("hello")
    public String hello() {
        System.out.println(name);
        return "hello";
    }

    @GetMapping("accounting")
    public String accounting() {
        AccountInfo accountingProject = accountInfoMapper.selectByPrimaryKey(1);
        return "hello";
    }
}
