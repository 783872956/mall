package com.hff.shoppingmall.Service;

import com.hff.shoppingmall.Bean.Product;
import com.hff.shoppingmall.Bean.ShoppingCart;
import com.hff.shoppingmall.Bean.ShoppingCartList;
import com.hff.shoppingmall.Mapper.ShoppingCartMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingCartService implements ShoppingCartMapper {

    @Autowired
    ShoppingCartMapper shoppingCartMapper;

    @Override
    public int insertShoppingCart(ShoppingCart shoppingCart) {
        return shoppingCartMapper.insertShoppingCart(shoppingCart);
    }

    @Override
    public ShoppingCart selectEachProdcut(ShoppingCart shoppingCart) {
        return shoppingCartMapper.selectEachProdcut(shoppingCart);
    }

    @Override
    public List<ShoppingCartList> selectVeryProduct(Integer userName) {
        return shoppingCartMapper.selectVeryProduct(userName);
    }

    @Override
    public Integer deleteProduct(String productID, Integer userName) {
        return shoppingCartMapper.deleteProduct(productID,userName);
    }

    @Override
    public Integer deleteProductAfterPayment(String productID) {
        return shoppingCartMapper.deleteProductAfterPayment(productID);
    }

}
