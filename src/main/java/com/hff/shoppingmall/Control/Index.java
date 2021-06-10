package com.hff.shoppingmall.Control;


import com.hff.shoppingmall.Bean.User;
import com.hff.shoppingmall.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@RequestMapping("/index")
public class Index {
    @Autowired
    UserService userService;

    @RequestMapping("/user")
    public User MainShow(Integer user_id){
        User user = userService.selectUserByUser_id(user_id);
        return user;
    }
}
