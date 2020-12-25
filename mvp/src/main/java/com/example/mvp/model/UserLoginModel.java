package com.example.mvp.model;

/**
 * Created by fan.zx
 * Date: 2020/12/21 15:38
 * Describe:
 */
public interface UserLoginModel {
    void login(String username,String password,UserLoginListener listener);
}
