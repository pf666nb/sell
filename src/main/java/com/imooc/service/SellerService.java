package com.imooc.service;

import com.imooc.dataobject.SellerInfo;

/**
 * @author wpf
 * @version 1.0
 * @date 2020/4/12 18:00
 */
public interface SellerService {


    /**
     * 根据openid查询卖家信息
     * @parm openid
     * @return
     * */
    SellerInfo findSellerInfoByOpenid(String openid );
}
