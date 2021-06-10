package com.hff.shoppingmall.Control;

import com.hff.shoppingmall.Bean.Product;
import com.hff.shoppingmall.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("api")
public class EachProduct {

    @Autowired
    ProductService productService;

    @RequestMapping(value = "/dashboard/selectEachProduct", method = RequestMethod.GET)
    @ResponseBody
    public Product selectEachProduct(@RequestParam String productID){
        Product product = productService.selectEachProduct(productID);
        return product;
    }
}
