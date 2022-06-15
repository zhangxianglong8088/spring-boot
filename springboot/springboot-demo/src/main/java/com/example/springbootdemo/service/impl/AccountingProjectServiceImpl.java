package com.example.springbootdemo.service.impl;

import com.example.springbootdemo.dao.AccountInfoDao;
import com.example.springbootdemo.dao.domain.AccountInfo;
import com.example.springbootdemo.service.AccountingInfoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @description：
 * @author: zhangxianglong
 * @date: 2022/2/20
 */
@Service
public class AccountingProjectServiceImpl implements AccountingInfoService {
    @Resource

    private AccountInfoDao accountInfoDao;

    @Override
    public AccountInfo getById(Integer id) {

        return accountInfoDao.getbyProjectId(id);
    }


    @Override
    public void saveNoTranstianl(AccountInfo accountInfo) {
        this.save(accountInfo);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(AccountInfo accountInfo) {
        accountInfoDao.save(accountInfo);
        try {
            int i = 1 / 0;

        } catch (Exception e) {

        }
    }
}
