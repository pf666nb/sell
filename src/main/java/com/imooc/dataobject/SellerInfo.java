package com.imooc.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author wpf
 * @version 1.0
 * @date 2020/4/12 17:53
 */
@Data
@Entity
public class SellerInfo {
    @Id
    private String sellerId;

    private String username;

    private String password;

    private String openid;



}
