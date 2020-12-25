package com.example.mvp.model;

/**
 * Created by fan.zx
 * Date: 2020/12/21 15:38
 * Describe:作为Login的参数，监听登录结果
 */
public interface UserLoginListener {
    void loginSucceeded();
    void loginFailed();
}
