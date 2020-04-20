package com.imooc.service.impl;

import com.imooc.dto.OrderDTO;
import com.imooc.service.OrderService;
import lombok.extern.slf4j.Slf4j;

import org.junit.Test;
import org.junit.jupiter.api.Order;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * @author wpf
 * @version 1.0
 * @date 2020/4/8 9:51
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class PayServiceImplTest {

    @Autowired
    private PayServiceImpl payService;
    @Autowired
    private OrderService orderService;
    @Test
    public void create() {
        OrderDTO orderDTO = orderService.findOne("1586139090859202005");
        payService.create(orderDTO);
    }
    @Test
    public void refund(){

        OrderDTO orderDTO = orderService.findOne("1586338148343756859");
        payService.refund(orderDTO);
    }
}