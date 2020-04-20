package com.imooc.utils;

import com.imooc.VO.ResultVO;
import org.springframework.stereotype.Repository;

/**
 * @author wpf
 * @version 1.0
 * @date 2020/4/4 18:10
 */
public class ResultVOUtil {
    public static ResultVO success(Object object){
        ResultVO resultVO = new ResultVO();
        resultVO.setData(object);
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        return resultVO;


    }
    public static  ResultVO success(){
        return success(null);


    }
    public static ResultVO error(Integer code,String msg){

        ResultVO resultVO = new ResultVO();
        resultVO.setMsg(msg);
        resultVO.setCode(code);
        return resultVO;
    }
}
