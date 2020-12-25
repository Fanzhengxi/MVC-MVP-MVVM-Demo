package com.example.mvc.model;

/**
 * Created by fan.zx
 * Date: 2020/12/18 16:36
 * Describe:
 */
public interface UserLoginModel {
    //处理登录的业务逻辑
    void login(String account,String passWord,UserLoginListener userLoginListener);
}
