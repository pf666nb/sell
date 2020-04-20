package com.imooc.service;

import com.imooc.dto.OrderDTO;

/**
 * maijia
 * @author wpf
 * @version 1.0
 * @date 2020/4/7 12:44
 */
public interface BuyerService {
    //查询一个订单
    OrderDTO findOrderOne(String openid,String orderId);
    //取消订单
    OrderDTO cancelOrder(String openid,String orderId);
}
