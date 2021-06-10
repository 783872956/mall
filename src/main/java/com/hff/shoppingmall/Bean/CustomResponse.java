package com.hff.shoppingmall.Bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CustomResponse implements Serializable {
    Object data;
    String message;
    Integer status;

}
