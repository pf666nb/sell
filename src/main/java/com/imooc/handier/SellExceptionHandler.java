package com.imooc.handier;

import com.imooc.VO.ResultVO;
import com.imooc.config.ProjectUrlConfig;
import com.imooc.exception.SellException;
import com.imooc.exception.SellerAuthorizeException;
import com.imooc.utils.ResultVOUtil;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author wpf
 * @version 1.0
 * @date 2020/4/13 12:09
 */

@ControllerAdvice
public class SellExceptionHandler {


    @Autowired
    private ProjectUrlConfig projectUrlConfig;
    //拦截登录异常
    @ExceptionHandler(value = SellerAuthorizeException.class)
    public ModelAndView handlerAuthorizeException(){

        return new ModelAndView("redirect:"+"https://open.weixin.qq.com/connect/qrconnect?appid=wx6ad144e54af67d87&redirect_uri=http://sell.springboot.cn/sell/qr/oTgZpwa4k4p3X0n7W7gO4GrZN8aU&response_type=code&scope=snsapi_login&state=http://jianyi.mynatapp.cc/sell/wechat/qrUserInfo");



    }
    @ExceptionHandler(value = SellException.class)
    @ResponseBody
    public ResultVO handlerSellerException(SellException e){

        return ResultVOUtil.error(e.getCode(),e.getMessage());
    }
}
