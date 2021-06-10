package com.hff.shoppingmall.Mapper.order;

import com.hff.shoppingmall.Bean.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface OrderMapper {

    @Insert("Insert into order1 (userName,totalPrice) values (#{userName},#{totalPrice})")
    @Options(useGeneratedKeys = true, keyProperty = "orderId", keyColumn = "orderId")
    int insertOrder(Order order);

    @Select("select * from order1 where userName=#{userName}")
    Order selectEachOrder(Integer userName);
}
