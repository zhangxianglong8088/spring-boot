package com.example.springbootdemo.service.zk.wacch;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static org.apache.zookeeper.ZooDefs.Ids.OPEN_ACL_UNSAFE;

/**
 * @description：监控到链接信息 监控不到创建结点的信息
 * 下面是对如何设置监控点的总结
 * - 对于NodeCreated 通过exists API设置
 * - 对于NodeDeleted 通过exists 和 getData()设置
 * - 对于NodeDataChanged 通过exists或getData设置
 * - 对于NodeChildrenChanged 通过getChildren设置
 * ————————————————
 * @author: zhangxianglong
 * @date: 2022/6/19
 */
public class WatcherExist implements Watcher {

    @Override
    public void process(WatchedEvent event) {
        System.out.println("Enter the process method,the event is :" + event);
        Event.EventType type = event.getType();
        switch (type) {
            case NodeCreated:
                System.out.println("新建节点:" + event.getPath());
            case NodeDeleted:
                System.out.println("删除节点:" + event.getPath());
            case NodeDataChanged:
                System.out.println("修改节点:" + event.getPath());
            case NodeChildrenChanged:
                System.out.println("子节点:" + event);
        }
    }

    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
        WatcherExist watcherDemo = new WatcherExist();
        String connectionString = "127.0.0.1:2181";
        ZooKeeper zooKeeper = new ZooKeeper(connectionString, 15 * 1000, watcherDemo, false);
        String path = "/watcherdemo01";

        String childPath = "/watcherdemo01/child01";

        Stat stat = zooKeeper.exists(path, watcherDemo);
        if (stat == null) {
            zooKeeper.create(path, "random".getBytes(), OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        }
        if (stat != null) {
            zooKeeper.delete(path, stat.getVersion());
        }
        TimeUnit.SECONDS.sleep(5);
        zooKeeper.close();
    }
}
