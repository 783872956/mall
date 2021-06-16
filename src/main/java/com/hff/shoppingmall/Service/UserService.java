package com.hff.shoppingmall.Service;

import com.hff.shoppingmall.Bean.User;
import com.hff.shoppingmall.Mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService  {

    @Autowired
    UserMapper userMapper;

    public int insertUser(User user) {
        return userMapper.insertUser(user);
    }

    public User selectUserByUser_id(Integer user_id) {

        return userMapper.selectUserByUser_id(user_id);
    }


}
