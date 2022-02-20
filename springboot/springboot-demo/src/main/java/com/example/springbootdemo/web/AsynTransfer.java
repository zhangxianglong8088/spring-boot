package com.example.springbootdemo.web;

import com.example.springbootdemo.service.Task;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Random;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @description：
 * @author: zhangxianglong
 * @date: 2022/2/18
 */
@RestController
public class AsynTransfer {

    @Resource
    private Task task;

    /**
     * @throws Exception
     * @Asyn普通使用
     */
    @GetMapping("asyn")
    public void asyntransfer() throws Exception {
        task.doTaskOne();
        task.doTaskTwo();
        task.doTaskThree();
    }

    /**
     * Asyn 返回值
     *
     * @throws Exception
     */
    @GetMapping("asynReturn")
    public void asynReturn() throws Exception {
        Future<String> future = task.doTaskFour();

        while (true) {
            if (future.isDone()) {
                System.out.println("task4 异步执行完成");
                break;
            }
            Thread.sleep(1000);
        }
    }

    /**
     * Asyn 自定义线程池使用
     *
     * @throws Exception
     */
    @GetMapping("asynThreadPool")
    public void asynThreadPool() throws Exception {
        task.doTaskFive();
    }

    /**
     * get方法中定义了该线程执行的超时时间，通过执行这个测试我们可以观察到执行时间超过5秒的时候，这里会抛出超时异常，
     * 该执行线程就能够因执行超时而释放回线程池，不至于一直阻塞而占用资源
     *
     * @throws Exception
     */
    @GetMapping("timeout")
    public void timeout() throws Exception {
        Future<String> future = task.doTaskSix();
        String result = future.get(5, TimeUnit.SECONDS);
        System.out.println("执行完了---" + result);
    }
}

