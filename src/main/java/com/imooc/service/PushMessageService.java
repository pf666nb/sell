package com.imooc.service;

import com.imooc.dto.OrderDTO;

/**
 * @author wpf
 * @version 1.0
 * @date 2020/4/13 12:51
 */
public interface PushMessageService {
    /**
     * 订单状态变更消息
     * */
    void orderStatus(OrderDTO orderDTO);
}
