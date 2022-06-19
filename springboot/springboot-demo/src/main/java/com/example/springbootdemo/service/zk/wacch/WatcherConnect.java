package com.example.springbootdemo.service.zk.wacch;

import org.apache.zookeeper.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static org.apache.zookeeper.ZooDefs.Ids.OPEN_ACL_UNSAFE;

/**
 * @description：监控到链接信息 监控不到创建结点的信息
 * @author: zhangxianglong
 * @date: 2022/6/19
 */
public class WatcherConnect implements Watcher {

    @Override
    public void process(WatchedEvent event) {
        System.out.println("Enter the process method,the event is :" + event);
        Event.EventType type = event.getType();
        switch (type) {
            case NodeDeleted:
                System.out.println("新建节点:" + event.getPath());
        }
    }

    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
        String connectionString = "127.0.0.1:2181";
        ZooKeeper zooKeeper = new ZooKeeper(connectionString, 15 * 1000, new WatcherConnect(), false);
        //create方法是没有Watcher相关方法的
        zooKeeper.create("/myEphmeralPath1", "random".getBytes(), OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
        TimeUnit.SECONDS.sleep(60);
        zooKeeper.close();
    }
}
