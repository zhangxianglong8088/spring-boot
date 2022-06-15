package com.example.springbootdemo.web;

import com.example.springbootdemo.dao.domain.AccountInfo;
import com.example.springbootdemo.dao.mapper.AccountInfoMapper;
import com.example.springbootdemo.service.AccountingInfoService;
import com.example.springbootdemo.service.observe.spring.MyEvent;
import com.example.springbootdemo.service.observe.spring.MyPublisher;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEvent;
import org.springframework.web.bind.annotation.GetMapping;
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
public class TestObseverController {

    @Resource
    private MyPublisher myPublisher;

    @GetMapping("publish")
    @ApiOperation(value = "发送事件", notes = "")
    public void test() {
        ApplicationEvent myEvent = new MyEvent("下雨了");
        myPublisher.publishEvent(myEvent);
    }
}
