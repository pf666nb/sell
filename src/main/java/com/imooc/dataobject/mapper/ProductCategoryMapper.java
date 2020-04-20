package com.imooc.dataobject.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

/**
 * @author wpf
 * @version 1.0
 * @date 2020/4/13 15:25
 */
@Mapper
public interface ProductCategoryMapper {
    @Insert("insert into product_category(category_name, category_type) values (#{category_name, jdbcType=VARCHAR}, #{category_type, jdbcType=INTEGER})")
    int insertByMap(Map<String,Object>map);
}
