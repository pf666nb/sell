package com.imooc.controller;

import com.imooc.dataobject.ProductCategory;
import com.imooc.dataobject.ProductInfo;
import com.imooc.exception.SellException;
import com.imooc.form.CategoryForm;
import com.imooc.service.CategoryService;
import com.imooc.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * @author wpf
 * @version 1.0
 * @date 2020/4/12 15:10
 */
@Controller
@RequestMapping("/seller/category")
public class SellerCategoryController {

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ProductService productService;

    @GetMapping("/list")
    public ModelAndView lsit(Map<String,Object>map){
        List<ProductCategory> categoryList = categoryService.finAll();
        map.put("categoryList",categoryList);
        return new ModelAndView("category/list",map);


    }
    /**
     * 保存更新
     * */
    @GetMapping("/index")
    public ModelAndView index(@RequestParam(value = "categoryId",required = false)Integer categoryId,
                              Map<String,Object>map){

        if (categoryId != null){

            ProductCategory productCategory = categoryService.findOne(categoryId);
            map.put("productCategory",productCategory);
        }
        return new ModelAndView("category/index",map);


    }
    @PostMapping("/save")
    public ModelAndView save(@Valid CategoryForm form,
                             BindingResult bindingResult,
                             Map<String,Object>map){
        if (bindingResult.hasErrors()){
            map.put("msg",bindingResult.getFieldError().getDefaultMessage());
            map.put("url","/sell/seller/category/index");
            return new ModelAndView("common/error",map);
        }
        ProductCategory productCategory = new ProductCategory();
       try {
           if (form.getCategoryId()!=null){
               productCategory = categoryService.findOne(form.getCategoryId());
               List<ProductInfo> productInfoList = productService.findTypeAll(productCategory.getCategoryType());
               for (ProductInfo s:productInfoList){
                   s.setCategoryType(form.getCategoryType());
               }
           }
           BeanUtils.copyProperties(form,productCategory);

           categoryService.save(productCategory);
       }catch (SellException e){

           map.put("msg", e.getMessage());
           map.put("url", "/sell/seller/category/index");
           return new ModelAndView("common/error", map);


       }
       map.put("url","/sell/seller/category/list");
       return new ModelAndView("common/success",map);

    }
}
