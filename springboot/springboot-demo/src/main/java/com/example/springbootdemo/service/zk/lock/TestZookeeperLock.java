package com.example.springbootdemo.service.zk.lock;

import com.example.springbootdemo.service.zk.watcher.WatcherConnect;
import org.apache.zookeeper.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static org.apache.zookeeper.ZooDefs.Ids.OPEN_ACL_UNSAFE;

/**
 * @description：测试zookeeper 分布式锁实现
 * @author: zhangxianglong
 * @date: 2022/6/19
 */
public class TestZookeeperLock {


    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {

        String connectionString = "127.0.0.1:2181";

        ZooKeeper zooKeeper1 = new ZooKeeper(connectionString, 15 * 1000, null, false);

        ZooKeeper zooKeeper2 = new ZooKeeper(connectionString, 15 * 1000, null, false);


        Thread t1 = new Thread(() -> {
            try {
                zooKeeper1.create("/lock/mylock", "random-1".getBytes(), OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
            } catch (KeeperException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });

        Thread t2 = new Thread(() -> {
            try {
                String res = zooKeeper2.create("/lock/mylock", "random-2".getBytes(), OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
            } catch (KeeperException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();
    }
}
