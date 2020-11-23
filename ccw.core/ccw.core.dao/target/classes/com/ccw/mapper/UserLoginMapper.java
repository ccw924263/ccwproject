package com.ccw.mapper;

import com.ccw.pojo.UserLogin;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserLoginMapper {
    //查询
    public List<UserLogin> queryAll();
    //添加数据
    public int add(UserLogin userLogin);
    //根据用户名查询数据
    public UserLogin queryByName(String username);
}