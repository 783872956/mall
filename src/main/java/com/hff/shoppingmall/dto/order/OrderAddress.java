package com.hff.shoppingmall.dto.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderAddress {
    public String address;
    public String postalCode;
    public String name;
    public String phone;
    public Integer orderAddressId;
}
