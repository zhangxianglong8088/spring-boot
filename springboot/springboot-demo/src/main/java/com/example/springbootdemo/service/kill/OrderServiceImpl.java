package com.example.springbootdemo.service.kill;

import com.example.springbootdemo.dao.domain.OrderInfo;
import com.example.springbootdemo.dao.domain.Stock;
import com.example.springbootdemo.dao.domain.StockExample;
import com.example.springbootdemo.dao.mapper.OrderInfoMapper;
import com.example.springbootdemo.dao.mapper.StockMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @description：
 * @author: zhangxianglong
 * @date: 2022/6/10
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderInfoMapper orderMapper;
    @Resource
    private StockMapper stockMapper;


    @Override
    public void seckill(Integer sku) {

        //创建订单
        OrderInfo order = new OrderInfo();
        order.setOrderId(10L);
        order.setSkuId(sku);
        order.setQty(1);
        orderMapper.insert(order);


        StockExample example = new StockExample();
        example.createCriteria().andSkuIdEqualTo(sku);
        Stock stock = stockMapper.selectByExample(example).stream().findFirst().orElse(null);

        //扣减mysql库存
        Stock stock4Update = new Stock();
        example.createCriteria().andSkuIdEqualTo(sku);
        stock4Update.setQty(stock.getQty() - 1);
        stockMapper.updateByExampleSelective(stock4Update, example);
    }
}
