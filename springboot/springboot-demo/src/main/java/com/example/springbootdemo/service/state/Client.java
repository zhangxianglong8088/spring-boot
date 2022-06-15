package com.example.springbootdemo.service.state;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 测试类
 *
 * @author 极客架构师@吴念
 * @createTime 2022/4/18
 */
public class Client {
    private static final Logger LOG = LoggerFactory.getLogger(Client.class);

    public static void main(String[] args) {
        LOG.info("状态模式开始测试");
        Client testOrderService = new Client();
        testOrderService.testPay();
    }

    public void testPay() {
        LOG.info("测试支付方法pay()");
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setID("1");
        orderInfo.setOrderStateEnum(OrderStateEnum.UNPAID);
        IOrderService orderService = new OrderService();
        //第一次支付
        orderService.pay(orderInfo);

        //第二次支付
        orderService.pay(orderInfo);
    }
}
