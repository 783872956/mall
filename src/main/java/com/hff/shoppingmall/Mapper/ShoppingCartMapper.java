package com.hff.shoppingmall.Mapper;

import com.hff.shoppingmall.Bean.ShoppingCart;
import com.hff.shoppingmall.Bean.ShoppingCartList;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ShoppingCartMapper {

    @Insert("insert into shopping_cart(productID,userName,count) values(#{productID},#{userName},#{count})")
    int insertShoppingCart(ShoppingCart shoppingCart);

    @Select("select * from shopping_cart where productID=#{productID} and userName=#{userName}")
    ShoppingCart selectEachProdcut(ShoppingCart shoppingCart);

    @Select("SELECT * FROM shopping_cart JOIN products USING(productID) WHERE userName=#{userName}")
    List<ShoppingCartList> selectVeryProduct(Integer userName);


    @Delete("DELETE FROM shopping_cart WHERE productID=#{arg0} AND userName =#{arg1}")
    Integer deleteProduct(String productID,Integer userName);

    @Delete("DELETE FROM shopping_cart WHERE productID = #{productID}")
    Integer deleteProductAfterPayment(String productID);
}
