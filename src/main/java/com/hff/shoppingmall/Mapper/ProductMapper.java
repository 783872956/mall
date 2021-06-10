package com.hff.shoppingmall.Mapper;

import com.hff.shoppingmall.Bean.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ProductMapper {

    @Select("select * from products where label like #{productLabel} LIMIT 10")
    List<Product> selectProductByProductLabel(String productLabel);

    @Select("select * from products")
    List<Product> selectAllProduct();

    @Select("select * from products where productID=#{productID}")
    Product selectEachProduct(String productID);

    @Insert("insert into products(productID,image,label,price) values(UUID(),#{image},#{label},#{price})")
    int insert(Product product);
}
