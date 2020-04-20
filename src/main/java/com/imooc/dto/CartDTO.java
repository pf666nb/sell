package com.imooc.dto;

import lombok.Data;

/**
 * @author wpf
 * @version 1.0
 * @date 2020/4/5 15:24
 */
@Data
public class CartDTO {

    /**商品ID*/
    private String productId;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }

    /***商品库存*/
    private Integer productQuantity;
}
