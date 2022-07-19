package com.example.springbootdemo.web;

import com.example.springbootdemo.ZookeeperWatcher;
import com.example.springbootdemo.service.kill.OrderService;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import lombok.extern.slf4j.Slf4j;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.ConcurrentHashMap;

import static org.apache.zookeeper.ZooDefs.Ids.OPEN_ACL_UNSAFE;

/**
 * @description：
 * @author: zhangxianglong
 * @date: 2022/2/10
 */
@RestController
@Slf4j
public class SeckillController {

    /**
     * jvm 级别缓存 存在分布式环境问题
     */

    public static ConcurrentHashMap<String, Boolean> productSoldOutMap = new ConcurrentHashMap<>();

    String REDIS_PRODUCT_STOCK_PREFIX = "redis_product_stock_prefix";

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    public ZooKeeper zooKeeper;

    @Resource
    private OrderService orderService;


    @GetMapping("kill/{productId}")
    @ApiOperation(value = "秒杀", notes = "")
    public String test(@PathVariable("productId") Integer productId) throws InterruptedException, KeeperException {

        try {
            zooKeeper.create("/zk_product_sold_out", null, OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
        } catch (Exception e) {

        }

        //redis库存已经扣减完成
        if (productSoldOutMap.get("zk_product_sold_out") != null) {
            return "商品已售罄";
        }
        Long stock = stringRedisTemplate.opsForValue().decrement(REDIS_PRODUCT_STOCK_PREFIX + productId);
        if (stock < 0) {
            //redis库存扣减完成
            //回填redis库存=0 避免出现负库存
            stringRedisTemplate.opsForValue().increment(REDIS_PRODUCT_STOCK_PREFIX + productId);
            //通知zookeeper
            if (zooKeeper.exists("/zk_product_sold_out", true) != null) {
                zooKeeper.setData("/zk_product_sold_out", "true".getBytes(), -1);
            }
            return "库存以售罄";
        }

        try {
            orderService.seckill(productId);
            int n = 10 / 0;
        } catch (Exception e) {
            //如果m创建订单，扣减库存失败 则回填redis的库存
            stringRedisTemplate.opsForValue().decrement(REDIS_PRODUCT_STOCK_PREFIX + productId);
            if (zooKeeper.exists("/zk_product_sold_out", true) != null) {
                zooKeeper.setData("/zk_product_sold_out", "false".getBytes(), -1);
            }
        }
        return "success";
    }
}
