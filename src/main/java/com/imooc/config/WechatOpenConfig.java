package com.imooc.config;

import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author wpf
 * @version 1.0
 * @date 2020/4/12 18:32
 */
@Component
public class WechatOpenConfig {

    @Autowired
    private WechatAccountConfig accountConfig;
    @Bean
    public WxMpService wxOpenService(){
        WxMpService wxOpenService = new WxMpServiceImpl();
        wxOpenService.setWxMpConfigStorage(wxOpenConfigStorage());
        return wxOpenService;

    }
    @Bean
    public WxMpInMemoryConfigStorage wxOpenConfigStorage(){
    WxMpInMemoryConfigStorage wxMpInMemoryConfigStorage = new WxMpInMemoryConfigStorage();
    wxMpInMemoryConfigStorage.setAppId(accountConfig.getOpenAppId());
    wxMpInMemoryConfigStorage.setSecret(accountConfig.getOpenAppSecret());
    return wxMpInMemoryConfigStorage;

    }


}
