package com.example.springbootdemo.service.state;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * 订单服务类（状态服务方角色）
 *
 * @author 极客架构师@吴念
 * @createTime 2022/4/15
 */
public class OrderService implements IOrderService {
    private static final Logger LOG = LoggerFactory.getLogger(OrderService.class);
    private Map<Integer, IOrderStateService> orderStateServiceMap = new HashMap<>();

    public OrderService() {
        //初始化状态服务对象
        orderStateServiceMap.put(OrderStateEnum.UNPAID.getCode(), new UnpaidOrderStateService(this));
        orderStateServiceMap.put(OrderStateEnum.PAID.getCode(), new PaidOrderStateService(this));
    }

    private IOrderStateService getOrderStateService(OrderInfo orderInfo) {
        IOrderStateService orderStateService = orderStateServiceMap.get(orderInfo.getOrderStateEnum().getCode());
        if (orderStateService != null) {
            return orderStateService;
        }
        throw new UnsupportedOperationException("该状态不支持");
    }

    @Override
    public boolean pay(OrderInfo orderInfo) {
        IOrderStateService orderStateService = getOrderStateService(orderInfo);
        return orderStateService.pay(orderInfo);
    }

    @Override
    public boolean reminder(OrderInfo orderInfo) {
        IOrderStateService orderStateService = getOrderStateService(orderInfo);
        return orderStateService.reminder(orderInfo);
    }

    @Override
    public boolean delete(OrderInfo orderInfo) {
        IOrderStateService orderStateService = getOrderStateService(orderInfo);
        return orderStateService.delete(orderInfo);
    }

    @Override
    public void changeState(OrderInfo orderInfo, OrderStateEnum newState) {
        LOG.info("订单状态：由{}转变为{}", orderInfo.getOrderStateEnum().getName(), newState.getName());
        orderInfo.setOrderStateEnum(newState);
    }
}
