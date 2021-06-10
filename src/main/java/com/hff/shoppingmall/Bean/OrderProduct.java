package com.hff.shoppingmall.Bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderProduct {
    String productID;
    Integer count;
    double price;
    Integer orderId;
}
