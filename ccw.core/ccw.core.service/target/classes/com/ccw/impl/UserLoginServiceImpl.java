package com.ccw.impl;

import com.ccw.IUserLoginService;
import com.ccw.mapper.UserLoginMapper;
import com.ccw.pojo.UserLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userLoginService")
public class UserLoginServiceImpl implements IUserLoginService {

    @Autowired
    private UserLoginMapper userLoginMapper;

    @Override
    public List<UserLogin> queryAll() {
        return userLoginMapper.queryAll();
    }

    @Override
    public int add(UserLogin userLogin) {
        return userLoginMapper.add(userLogin);
    }

    @Override
    public UserLogin queryByName(String username) {
        return userLoginMapper.queryByName(username);
    }
}