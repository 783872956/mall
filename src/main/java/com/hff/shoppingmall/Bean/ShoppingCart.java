package com.hff.shoppingmall.Bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShoppingCart {
    private String productID;
    private Integer userName;
    private Integer count;
}
