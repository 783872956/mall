package com.hff.shoppingmall.Bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderAddress {
    public Integer orderAddressId;
    public String address;
    public String postalCode;
    public String name;
    public String phone;
    public Integer orderId;
}
