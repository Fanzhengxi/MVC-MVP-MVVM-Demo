package com.example.mvc.model;

/**
 * Created by fan.zx
 * Date: 2020/12/18 16:37
 * Describe:监听登录成功还是失败
 */
public interface UserLoginListener {
    //登录成功
    void loginSuccess();
    //登陆失败
    void loginFiled();
}
