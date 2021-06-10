package com.hff.shoppingmall.Control;

import com.hff.shoppingmall.Bean.CustomResponse;
import com.hff.shoppingmall.dto.order.Order;
import com.hff.shoppingmall.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("api")
public class OrderController {

    @Autowired
    OrderService orderService;

    @RequestMapping(value = "/dashboard/InsertOrder", method = RequestMethod.POST)
    @ResponseBody
    public CustomResponse selectEachProduct(@RequestBody Order order){
        int result = orderService.insertOrder(order);
        if (result > 0) {
            return new CustomResponse(true,"",200);
        }
        return new CustomResponse(false,"购买失败",400);

    }
}
