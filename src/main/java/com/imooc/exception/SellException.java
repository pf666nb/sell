package com.imooc.exception;

import com.imooc.enums.ResultEnum;
import lombok.Getter;

/**
 * @author wpf
 * @version 1.0
 * @date 2020/4/5 12:51
 */
@Getter
public class SellException extends RuntimeException{

    private Integer code;

    public SellException(ResultEnum resultEnum) {

        super(resultEnum.getMessage());

        this.code = resultEnum.getCode();
    }
    public SellException(Integer code,String message){
        super(message);
        this.code = code;

    }
}
