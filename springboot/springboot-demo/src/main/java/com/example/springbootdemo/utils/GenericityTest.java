package com.example.springbootdemo.utils;

/**
 * @description：
 * @author: zhangxianglong
 * @date: 2022/5/5
 */
public class GenericityTest {


    public static <E> E test(E a) {
        System.out.println(a);
        return a;
    }

    public static void main(String[] args) {
        String s = test("3456");
        Integer a = test(123);
    }
}
