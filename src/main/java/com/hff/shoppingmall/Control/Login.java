package com.hff.shoppingmall.Control;

import com.hff.shoppingmall.Bean.CustomResponse;
import com.hff.shoppingmall.Bean.User;
import com.hff.shoppingmall.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@RequestMapping("/api")
public class Login {

    @Autowired
    UserService userService;

    @RequestMapping("/user/login")
    public CustomResponse login(@RequestBody User user){
        System.out.println(user);
        User user1 = userService.selectUserByUser_id(user.getUserName());
        if(user1 == null || !user1.getPassword().equals(user.getPassword())){
            System.out.println("失败");
            return new CustomResponse(null, "用户名或密码错误", 500);
        } else {
            System.out.println("成功");
            user1.setPassword(null);
            return new CustomResponse(user1, "", 200);
        }
    }
}
