package com.lz.service;

import com.lz.po.User;

import java.util.List;

public interface UserService {
    /**
     * 通过username查找用户是否存在
     * @param username
     * @return
     */
    String selectUser(String username);
    /**
     * 通过用户名和密码查询用户类型
     * @param user
     * @return
     */
    String isUser(User user);
    /**
     * 添加用户
     * @param user
     */
    void insterUser(User user);
    /**
     * 删除用户
     * @param username
     */
    void deleteUser(String username);
    /**
     * 分页查询
     * @param startrow
     * @param pagesize
     * @return
     */
    List<User> selectAllUserByPages(int startrow, int pagesize);
    /**
     * 查询所有用户
     * @return
     */
    List<User> selectAllUser();
    /**
     * 查询用户数量
     * @return
     */
    String selectUsersNum();
    /**
     * 查询用户信息
     * @param username
     * @return
     */
    User selectUserMessage(String username);
    /**
     * 更新用户信息
     * @param user
     */
    int updateUser(User user);
}
