package com.hff.shoppingmall.Mapper.order;

import com.hff.shoppingmall.Bean.OrderAddress;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderAddressMapper {

    @Insert("insert into order_address (address,postalCode,name,phone) values(#{address},#{postalCode},#{name},#{phone})")
    int insertOrderAddress(OrderAddress orderAddress);
}
