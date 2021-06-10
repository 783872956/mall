package com.hff.shoppingmall.dao.order;

import com.hff.shoppingmall.Bean.Order;
import com.hff.shoppingmall.Bean.OrderAddress;
import com.hff.shoppingmall.Bean.OrderProduct;
import com.hff.shoppingmall.Mapper.order.OrderAddressMapper;
import com.hff.shoppingmall.Mapper.order.OrderMapper;
import com.hff.shoppingmall.Mapper.order.OrderProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderDao {

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    OrderAddressMapper orderAddressMapper;

    @Autowired
    OrderProductMapper orderProductMapper;

    public int insertOrder(Order order) {
        return orderMapper.insertOrder(order);
    }

    public int insertOrderAddress(OrderAddress orderAddress) {
        return orderAddressMapper.insertOrderAddress(orderAddress);
    };

    public int insertOrderProduct(OrderProduct orderProduct) {
        return orderProductMapper.insertOrderProduct(orderProduct);
    };

    public Order selectEachOrder(Integer userName) {
        return orderMapper.selectEachOrder(userName);
    }

}
