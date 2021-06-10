package com.hff.shoppingmall.Control;

import com.hff.shoppingmall.Bean.CustomResponse;
import com.hff.shoppingmall.Bean.Product;
import com.hff.shoppingmall.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("api")
public class ProductController {

    @Autowired
    ProductService productService;

    @RequestMapping(value = "/dashboard/searchProductAutoComplete", method = RequestMethod.GET)
    @ResponseBody
    public CustomResponse searchProductAutoComplete(@RequestParam String searchKeyword){
        List<Product> list = productService.selectProductByProductLabel(searchKeyword);
        return new CustomResponse(list,null,200);
    }

}
