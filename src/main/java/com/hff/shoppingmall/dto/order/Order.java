package com.hff.shoppingmall.dto.order;

import com.hff.shoppingmall.Bean.OrderAddress;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    public Integer orderId;
    public Integer userName;
    public List<OrderProduct> productList;
    public OrderAddress orderAddress;
    public double totalPrice;
}
