package com.hff.shoppingmall.Mapper;

import com.hff.shoppingmall.Bean.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Insert("Insert into shopmalluser(userName,password) values(#{userName},#{password})")
    int insertUser(User user);

    @Select("select * from shopmalluser where userName=#{user_id}")
    User selectUserByUser_id(Integer user_id);
}
