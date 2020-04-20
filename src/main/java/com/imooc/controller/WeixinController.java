package com.imooc.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author wpf
 * @version 1.0
 * @date 2020/4/7 15:04
 */
@RestController
@RequestMapping("/weixin")
@Slf4j
public class WeixinController {

    @GetMapping("/auth")
    public void auth(@RequestParam("code")String code){
        log.info("进入auth方法");
        log.info("code={}",code);
        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=wx17c5c7866139e083&secret=7a57e3c35c5c711c5bbee6084f963283&code="+code+"&grant_type=authorization_code";
        RestTemplate restTemplate = new RestTemplate();
        String  response = restTemplate.getForObject(url,String.class);
        log.info("response={}",response);

    }

}
