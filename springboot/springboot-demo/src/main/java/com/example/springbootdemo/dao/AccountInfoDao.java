package com.example.springbootdemo.dao;

import com.example.springbootdemo.dao.domain.AccountInfo;

/**
 * @description：
 * @author: zhangxianglong
 * @date: 2022/2/19
 */
public interface AccountInfoDao {

    AccountInfo getbyProjectId(Integer projectId);


    void save(AccountInfo accountInfo);
}
