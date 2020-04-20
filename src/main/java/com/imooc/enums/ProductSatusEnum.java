package com.imooc.enums;


import lombok.Getter;

/**
 * 商品状态
 * @author wpf
 * @version 1.0
 * @date 2020/4/4 13:27
 */
@Getter
public enum ProductSatusEnum implements CodeEnum{
    UP(0,"在架"),
    DOWN(1,"下架")
    ;
    private Integer code;

    private  String message;

    ProductSatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
