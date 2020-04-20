package com.imooc.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author wpf
 * @version 1.0
 * @date 2020/4/4 10:49
 */
@Entity
@DynamicUpdate
@Data
public class ProductCategory {


    /**类目id*/
    @Id
    @GeneratedValue
    private Integer categoryId;
    /**类目名字*/
    private String categoryName;
    /**类目编号*/
    private Integer categoryType;

    private Date createTime;

    private Date updateTime;

    public ProductCategory() {

    }

    public ProductCategory(String categoryName, Integer categoryType) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }
}
