package com.imooc.service.impl;

import com.imooc.dto.OrderDTO;
import com.imooc.service.PushMessageService;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * @author wpf
 * @version 1.0
 * @date 2020/4/13 12:52
 */
@Service
@Slf4j
public class PushMessageServiceImpl implements PushMessageService {
    @Autowired
    private WxMpService wxMpService;

    @Override
    public void orderStatus(OrderDTO orderDTO) {
        WxMpTemplateMessage templateMessage = new WxMpTemplateMessage();
        templateMessage.setTemplateId("yBVQdfkQ4UYYgW58EAhtH6Iy_xo6bu3d-TsJXHkSjN0");
        templateMessage.setToUser("o0Rj6sifS19lZedImab0BOy9XhGE");
        List<WxMpTemplateData> data = Arrays.asList(
                new WxMpTemplateData("first","记得收货"),
                new WxMpTemplateData("keyword1","微信点餐"),
                new WxMpTemplateData("keyword2","1231321321"),
                new WxMpTemplateData("keyword3",orderDTO.getOrderId()),
                new WxMpTemplateData("keyword4",orderDTO.getOrderStatusEnum().getMessage()),
                new WxMpTemplateData("keyword1","^"+orderDTO.getOrderAmount())

        );
        templateMessage.setData(data);
        try {
            wxMpService.getTemplateMsgService().sendTemplateMsg(templateMessage);
        }catch (WxErrorException e){
            log.error("【微信模板消息】发送失败,{}",e);

        }
    }
}
