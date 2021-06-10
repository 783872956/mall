package com.hff.shoppingmall.dto.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderProduct {
    public String productID;
    public Integer count;
    public Double price;
}
