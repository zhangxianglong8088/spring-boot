package com.example.springbootdemo.config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @description：
 * @author: zhangxianglong
 * @date: 2022/3/21
 */
@Component
public class FactoryBean implements ApplicationContextAware {
    private static ApplicationContext applicationContext;

    private void init(ApplicationContext context) {
        applicationContext = context;
    }

    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        init(context);

    }

    public static Object getBean(String beanId) {
        return applicationContext.getBean(beanId);
    }

    public static Object getBean(Class clz) {
        return applicationContext.getBean(clz);
    }

}
