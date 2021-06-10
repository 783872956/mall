package com.hff.shoppingmall.Bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShoppingCartList {
    private String productID;
    private Integer userName;
    private Integer count;
    private String image;
    private String label;
    private Double price;

}
