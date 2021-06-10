package com.hff.shoppingmall.Control;

import com.hff.shoppingmall.Bean.CustomResponse;
import com.hff.shoppingmall.Bean.OrderProduct;
import com.hff.shoppingmall.Bean.ShoppingCart;
import com.hff.shoppingmall.Bean.ShoppingCartList;
import com.hff.shoppingmall.Service.ShoppingCartService;
import com.hff.shoppingmall.dto.order.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("api")
public class ShoppingCartController {
    @Autowired
    ShoppingCartService shoppingCartService;

    //商品加入购物车
    @RequestMapping(value = "/dashboard/InsertShopCart", method = RequestMethod.POST)
    @ResponseBody
    public CustomResponse insertEachProduct(@RequestBody ShoppingCart shoppingCart){
        int result = shoppingCartService.insertShoppingCart(shoppingCart);
        if (result > 0) {
            return new CustomResponse(true,"",200);
        }
        return new CustomResponse(false,"加入失败",400);

    }

    //通过用户名显示相对应的购物车信息
    @RequestMapping(value = "/dashboard/selectVeryProduct", method = RequestMethod.GET)
    @ResponseBody
    public List<ShoppingCartList> selectVeryProduct(@RequestParam Integer userName){

        List<ShoppingCartList> list = shoppingCartService.selectVeryProduct(userName);
            return list;
    }

    //从购物车删除商品
    @RequestMapping(value = "/dashboard/deleteProduct", method = RequestMethod.DELETE)
    @ResponseBody
    public CustomResponse deleteProduct(@RequestBody ShoppingCart shoppingCart){

        Integer result = shoppingCartService.deleteProduct(shoppingCart.getProductID(),shoppingCart.getUserName());
        if(result==0){
            return new CustomResponse(null,"没有此商品",400);
        }
        return new CustomResponse(null,"删除成功",200);

    }

    //从购物车购买成功后删除相对应的商品
    @RequestMapping(value = "/dashboard/deleteProductAfterPayment", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteProductAfterPayment(@RequestBody Order order){
        for(int i = 0;i<order.getProductList().size();i++){
            shoppingCartService.deleteProductAfterPayment(order.productList.get(i).productID);
        }
    }

}
