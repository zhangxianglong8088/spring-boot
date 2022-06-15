package com.example.springbootdemo.service.circula;

/**
 * @description：模拟Spring循环依赖
 * @author: zhangxianglong
 * @date: 2022/5/8
 */
public class CircularDependency {

   static class ClazzA {

        private ClazzB b = new ClazzB();

    }

  static   class ClazzB {

        private ClazzA a = new ClazzA();

    }


    public static void main(String[] args) {
        new ClazzA();
    }
}
