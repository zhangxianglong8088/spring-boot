package com.example.springbootdemo;

import com.example.springbootdemo.web.SeckillController;
import lombok.SneakyThrows;
import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import static com.example.springbootdemo.web.SeckillController.productSoldOutMap;

/**
 * @description：
 * @author: zhangxianglong
 * @date: 2022/6/19
 */
@Component
public class ZookeeperWatcher implements Watcher, ApplicationContextAware {

    private ZooKeeper zooKeeper;

    private static ApplicationContext applicationContext;

    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @SneakyThrows
    @Override
    public void process(WatchedEvent event) {

        if (event.getType() == Event.EventType.None && event.getPath() == null) {
            System.out.println("zk链接成功");
            if (zooKeeper == null) {
                zooKeeper = applicationContext.getBean(ZooKeeper.class);
            }
//            try {
//                if (zooKeeper.exists("/zk_product_sold_out", false) == null) {
//                    zooKeeper.create("/zk_product_sold_out", "".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
//                }
//            } catch (Exception e) {
//
//            }

        } else if (event.getType() == Event.EventType.NodeDataChanged) {
            try {
                String path = event.getPath();
                String soldOutFlag = new String(zooKeeper.getData(path, true, new Stat()));
                System.out.println("zookeeper 数据结点发生变动，path,soldOutFlag" + "" + path + "" + soldOutFlag);
                if ("false".equals(soldOutFlag)) {
                    String productId = path.substring(path.lastIndexOf("/") + 1, path.length());
                    //删除内存标记
                    productSoldOutMap.remove(productId);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
