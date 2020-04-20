package com.imooc.service.impl;
import com.imooc.dataobject.ProductCategory;
import com.imooc.dataobject.ProductInfo;
import com.imooc.dto.CartDTO;
import com.imooc.enums.ProductSatusEnum;
import com.imooc.enums.ResultEnum;
import com.imooc.exception.SellException;
import com.imooc.repository.ProductInfoRepository;
import com.imooc.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author wpf
 * @version 1.0
 * @date 2020/4/4 13:26
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductInfoRepository repository;

    @Override
    public List<ProductInfo> findTypeAll(Integer categoryType) {


        return  repository.findByCategoryType(categoryType);
    }

    @Override
    public ProductInfo onSale(String productId) {
        ProductInfo productInfo = repository.findOne(productId);
        if (productInfo == null){

            throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
        }
        if (productInfo.getProductSatusEnum() == ProductSatusEnum.UP){

            throw new SellException(ResultEnum.PRODUCT_STATUS_ERROR);
        }
        productInfo.setProductStatus(ProductSatusEnum.UP.getCode());
        //更新
       return repository.save(productInfo);


    }

    @Override
    public ProductInfo offSale(String productId) {
        ProductInfo productInfo = repository.findOne(productId);
        if (productInfo == null){

            throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
        }
        if (productInfo.getProductSatusEnum() == ProductSatusEnum.DOWN){

            throw new SellException(ResultEnum.PRODUCT_STATUS_ERROR);
        }
        productInfo.setProductStatus(ProductSatusEnum.DOWN.getCode());
        //更新
        return repository.save(productInfo);
    }

    @Override
    public ProductInfo findOne(String productId) {
        return repository.findOne(productId);
    }

    @Override
    public List<ProductInfo> findUpAll() {
        return repository.findByProductStatus(ProductSatusEnum.UP.getCode());
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {

        return repository.save(productInfo);
    }

    @Override
    @Transactional
    public void increaseStock(List<CartDTO> cartDTOList) {
            for (CartDTO cartDTO : cartDTOList){
                ProductInfo productInfo = repository.findOne(cartDTO.getProductId());
                if(productInfo == null){

                    throw  new SellException(ResultEnum.PRODUCT_NOT_EXIST);
                }
                Integer result = productInfo.getProductStock() +cartDTO.getProductQuantity();
                productInfo.setProductStock(result);
                repository.save(productInfo);

            }
    }

    @Override
    @Transactional
    public void decreaseStock(List<CartDTO> cartDTOList) {
        for(CartDTO cartDTO: cartDTOList){
        ProductInfo productInfo  =    repository.findOne(cartDTO.getProductId());
        if (productInfo == null){
            throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
        }
        Integer result = productInfo.getProductStock()-cartDTO.getProductQuantity();
        if (result<0){

            throw new SellException(ResultEnum.PRODUCT_STOCK_ERROR);
        }
        productInfo.setProductStock(result);

        repository.save(productInfo);
        }
    }
}
