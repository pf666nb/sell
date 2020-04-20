package com.imooc.VO;

import lombok.Data;

/**gttp处理请求
 * @author wpf
 * @version 1.0
 * @date 2020/4/4 16:11
 */
@Data

public class ResultVO<T> {

    /**错误码*/
    private Integer code;
    /**提示信息*/
    private String msg;
    /**具体内容*/
    private  T data;

}
