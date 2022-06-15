package com.example.springbootdemo.impl;

import com.example.springbootdemo.dao.AccountInfoDao;
import com.example.springbootdemo.dao.domain.AccountInfo;
import com.example.springbootdemo.dao.mapper.AccountInfoMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @description：
 * @author: zhangxianglong
 * @date: 2022/2/19
 */
@Repository
public class AccountInforDaoImpl implements AccountInfoDao {


    @Resource
    private AccountInfoMapper projectMapper;

    @Override
    public AccountInfo getbyProjectId(Integer id) {
        return projectMapper.selectByPrimaryKey(id);
    }

    @Override
    public void save(AccountInfo accountInfo) {
        projectMapper.insertSelective(accountInfo);
//        int a = 1 / 0; //主动抛出异常，观察数据是否回滚
    }
}
