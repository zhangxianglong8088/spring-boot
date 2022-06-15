package com.example.springbootdemo.web;

import com.example.springbootdemo.service.kill.OrderService;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.ConcurrentHashMap;

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

    ConcurrentHashMap<Integer, Boolean> productSoldOutMap = new ConcurrentHashMap<>();

    String REDIS_PRODUCT_STOCK_PREFIX = "redis_product_stock_prefix";

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private OrderService orderService;


    @GetMapping("kill/{productId}")
    @ApiOperation(value = "秒杀", notes = "")
    public String test(@PathVariable("productId") Integer productId) {

        //redis库存已经扣减完成
        if (productSoldOutMap.get(productId) != null) {
            return "商品已售罄";
        }
        Long stock = stringRedisTemplate.opsForValue().decrement(REDIS_PRODUCT_STOCK_PREFIX + productId);

        if (stock < 0) {
            productSoldOutMap.put(productId, true);
            stringRedisTemplate.opsForValue().increment(REDIS_PRODUCT_STOCK_PREFIX + productId);
            return "商品已售罄";
        }

        try {
            orderService.seckill(productId);
        } catch (Exception e) {
            //如果m创建订单，扣减库存失败 则回填redis的库存
            stringRedisTemplate.opsForValue().decrement(REDIS_PRODUCT_STOCK_PREFIX + productId);
        }
        return "success";
    }
}
