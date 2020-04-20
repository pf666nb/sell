package com.imooc.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author wpf
 * @version 1.0
 * @date 2020/4/7 17:22
 */
@Data
@Component
@ConfigurationProperties(prefix = "wechat")
public class WechatAccountConfig {


    /**开放平台id*/
    private String openAppId;
    /**开放平台密钥*/
    private String openAppSecret;

    private String zfmpAppId;
    private String mpAppId;
    private String mpAppSecret;

    /**商户号*/
    private String mchId;
    /**商户号*/
    private String mchKey;
    /**商户证书路径*/
    private String keyPath;
    /**微信异步通知*/
    private String notifyUrl;
}
