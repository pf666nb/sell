package com.imooc.utils;

import java.util.Random;

/**
 * @author wpf
 * @version 1.0
 * @date 2020/4/5 14:17
 */
public class KeyUtil {

    /**生成唯一的主键
     * 格式：时间加上随机数
     * @return
     * */
    public static synchronized String genUniqueKey(){
        Random random = new Random();

        Integer number = random.nextInt(900000)+100000;
        return System.currentTimeMillis()+String.valueOf(number);
    }
}
