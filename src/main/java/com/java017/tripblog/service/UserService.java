package com.java017.tripblog.service;

import com.java017.tripblog.entity.User;

/**
 * @author YuCheng
 * @date 2021/9/27 - 下午 02:05
 */

public interface UserService {

    //確認用戶帳密
    User checkUser(String account, String password);

    //創建會員
    boolean createUser(User user);

    //帳號查詢會員資料
    User findUserByAccount(String account);

    //編號查詢會員資料
    User findUserById(Long id);

    //修改會員資料
    User updateUser(User user);

}