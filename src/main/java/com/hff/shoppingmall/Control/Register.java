package com.hff.shoppingmall.Control;

import com.hff.shoppingmall.Bean.CustomResponse;
import com.hff.shoppingmall.Bean.User;
import com.hff.shoppingmall.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api")
public class Register {

    @Autowired
    UserService userService;

    @ResponseBody
    @RequestMapping(value = "/register/getUser", method = RequestMethod.POST)
    public CustomResponse save(@RequestBody User user){
        System.out.println(user);
        System.out.println(user.getUserName());
        User user1 = userService.selectUserByUser_id(user.getUserName());
        System.out.println(user1);
        //代表已经被注册
        if(user1 != null) {
            return new CustomResponse(null, "用户已被注册", 500);
        }
        user.setPassword(user.getPassword());
        userService.insertUser(user);
        user.setPassword(null);
        return new CustomResponse(user, "", 200);
    }
}
