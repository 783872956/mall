package com.hff.shoppingmall.Mapper.order;

import com.hff.shoppingmall.Bean.OrderProduct;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderProductMapper {

    @Insert("insert into order_product (productID,count,price,orderId) values(#{productID},#{count},#{price},#{orderId})")
    int insertOrderProduct(OrderProduct orderProduct);
}
