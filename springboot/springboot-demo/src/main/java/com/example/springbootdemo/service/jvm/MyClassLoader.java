package com.example.springbootdemo.service.jvm;

/**
 * @description：
 * @author: zhangxianglong
 * @date: 2022/6/24
 */
public class MyClassLoader extends ClassLoader {

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        throw new ClassNotFoundException(name);
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        return loadClass(name, false);
    }

}
