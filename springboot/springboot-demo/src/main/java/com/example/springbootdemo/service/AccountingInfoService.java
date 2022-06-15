package com.example.springbootdemo.service;

import com.example.springbootdemo.dao.domain.AccountInfo;

/**
 * @description：
 * @author: zhangxianglong
 * @date: 2022/2/20
 */
public interface AccountingInfoService {

    AccountInfo getById(Integer id);

    void saveNoTranstianl(AccountInfo accountInfo);

    void save(AccountInfo accountInfo);
}
