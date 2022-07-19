package com.example.springbootdemo.service.zk.watcher;

import org.apache.zookeeper.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @description：
 * @author: zhangxianglong
 * @date: 2022/6/19
 */
public class CallBackDemo implements Watcher {

    public static void main(String[] args) throws InterruptedException, IOException {

        String connectionString = "127.0.0.1:2181";
        ZooKeeper zooKeeper = new ZooKeeper(connectionString, 15 * 1000, new CallBackDemo(), false);
        String path = "/callBackDemo";
        String params = "123";
        zooKeeper.create(path, "".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT, (rc, path1, ctx, name) -> {
            System.out.println("Object ctx 参数对应于create 方法最后一个参数");
            System.out.println(ctx.toString());
            KeeperException.Code code = KeeperException.Code.get(rc);
            switch (code) {
                case OK:
                case NOAUTH:
                case NONODE:
                case APIERROR:
                case NOTEMPTY:
                case AUTHFAILED:
                case BADVERSION:
                case INVALIDACL:
                case NODEEXISTS:
                case NOTREADONLY:
                case SYSTEMERROR:
                case BADARGUMENTS:
                case SESSIONMOVED:
                case UNIMPLEMENTED:
                case CONNECTIONLOSS:
                case SESSIONEXPIRED:
                case INVALIDCALLBACK:
                case MARSHALLINGERROR:
                case OPERATIONTIMEOUT:
                case DATAINCONSISTENCY:
                case RUNTIMEINCONSISTENCY:
                case NOCHILDRENFOREPHEMERALS:
            }
        }, params);
        TimeUnit.SECONDS.sleep(10);
    }


    @Override
    public void process(WatchedEvent event) {

    }
}
