package com.example.springbootdemo.service.jvm.gcroot;


/**
 * @description：方法区类的静态成员引用的对象
 * @author: zhangxianglong
 * @date: 2022/7/15
 */
public class GCRoot2 {
    private static int _10MB = 10 * 1024 * 1024;
    private byte[] memror;
    private static GCRoot2 t;

    public GCRoot2(int size) {
        memror = new byte[size];
    }

    public static void main(String[] args) {
        GCRoot2 t2 = new GCRoot2(4 * _10MB);
        t2.t = new GCRoot2(8 * _10MB);
        t2 = null;
        System.gc();
    }
}
