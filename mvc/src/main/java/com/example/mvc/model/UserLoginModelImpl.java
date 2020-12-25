package com.example.mvc.model;

import android.os.Handler;
import android.util.Log;

/**
 * Created by fan.zx
 * Date: 2020/12/18 16:42
 * Describe:MVC的Model层
 * 登录：网络请求
 */
public class UserLoginModelImpl implements UserLoginModel {
    private final String TAG=getClass().getSimpleName();
    @Override
    public void login(String account, String passWord, UserLoginListener userLoginListener) {
        Log.d(TAG,"登录中");
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if ("jike".equals(account)&& "123".equals(passWord)){
                    userLoginListener.loginSuccess();
                }else{
                    userLoginListener.loginFiled();
                }
            }
        },3000);

    }
}
