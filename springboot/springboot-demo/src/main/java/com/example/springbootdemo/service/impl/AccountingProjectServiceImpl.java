package com.example.springbootdemo.service.impl;

import com.example.springbootdemo.dao.AccountInfoDao;
import com.example.springbootdemo.dao.domain.AccountInfo;
import com.example.springbootdemo.service.AccountingInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @description：
 * @author: zhangxianglong
 * @date: 2022/2/20
 */
@Service
public class AccountingProjectServiceImpl implements AccountingInfoService {
    @Resource

    private AccountInfoDao accountingProjectDao;

    @Override
    public AccountInfo getById(Integer id) {

        return accountingProjectDao.getbyProjectId(id);
    }
}
