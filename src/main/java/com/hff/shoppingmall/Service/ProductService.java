package com.hff.shoppingmall.Service;

import com.hff.shoppingmall.Bean.Product;
import com.hff.shoppingmall.Mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductService implements ProductMapper{

    @Autowired
    ProductMapper productMapper;


    public List<Product> selectProductByProductLabel(String productLabel) {
        return productMapper.selectProductByProductLabel("%" + productLabel + "%");
    }

    public List<Product> selectAllProduct() {
        return productMapper.selectAllProduct();
    }

    @Override
    public Product selectEachProduct(String productID) {
        return productMapper.selectEachProduct(productID);
    }

    @Override
    public int insert(Product product) {
        return productMapper.insert(product);
    }


}
