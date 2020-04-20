package com.imooc.converter;

import com.imooc.dataobject.OrderMaster;
import com.imooc.dto.OrderDTO;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wpf
 * @version 1.0
 * @date 2020/4/5 18:18
 */
public class OrderMaster2OrderDTOConverter {

    public static OrderDTO convert(OrderMaster orderMaster){

    OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderMaster,orderDTO);
        return orderDTO;

    }
    public static List<OrderDTO> convert(List<OrderMaster> orderMasterList){

       return orderMasterList.stream().map(e->
                convert(e)
        ).collect(Collectors.toList());


    }


}
