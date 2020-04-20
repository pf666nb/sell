package com.imooc.service;

import com.imooc.dataobject.ProductCategory;

import java.util.List;

/**
 * @author wpf
 * @version 1.0
 * @date 2020/4/4 11:54
 */
public interface CategoryService {
    ProductCategory findOne(Integer categoryId);

    List<ProductCategory> finAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory save (ProductCategory productCategory);

}
