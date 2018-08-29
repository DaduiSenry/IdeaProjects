package com.lz.service.impl;

import com.lz.mapper.UserMapper;
import com.lz.po.User;
import com.lz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public String selectUser(String username) {
        String utype=userMapper.selectUser(username);
        return utype;
    }

    @Override
    public String isUser(User user) {
        String uname=userMapper.isUser(user);
        return uname;
    }

    @Override
    public void insterUser(User user) {
        userMapper.insterUser(user);
    }

    @Override
    public List<User> selectAllUserByPages(int startrow, int pagesize) {
        List<User> users = userMapper.selectAllUserByPages(startrow,pagesize);
        return users;
    }

    @Override
    public List<User> selectAllUser() {
        List<User> users=userMapper.selectAllUser();
        return users;
    }

    @Override
    public String selectUsersNum() {
        String usersNum = userMapper.selectUsersNum();
        return usersNum;
    }

    @Override
    public void deleteUser(String username) {
        userMapper.deleteUser(username);
    }

    @Override
    public User selectUserMessage(String username) {
        User user=userMapper.selectUserMessage(username);
        return user;
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }
}
