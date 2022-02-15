package com.example.springbootdemo.web;

import com.example.springbootdemo.dao.domain.AccountingProject;
import com.example.springbootdemo.dao.mapper.AccountingProjectMapper;
import io.swagger.annotations.ApiOperation;
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
public class UserController {

    @Resource
    private AccountingProjectMapper accountingProjectMapper;

    @Value("${name}")
    private String name;

    @GetMapping("test")
    @ApiOperation(value = "获取用户列表", notes = "")
    public String test() {
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
        AccountingProject accountingProject = accountingProjectMapper.selectByPrimaryKey(22L);
        return "hello";
    }
}
