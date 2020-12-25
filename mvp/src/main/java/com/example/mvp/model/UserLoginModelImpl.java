package com.example.mvp.model;

import android.os.Handler;
import android.text.TextUtils;

/**
 * Created by fan.zx
 * Date: 2020/12/21 15:48
 * Describe:
 */
public class UserLoginModelImpl implements UserLoginModel {
    @Override
    public void login(String username, String password, UserLoginListener listener) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (TextUtils.equals("jike",username) && TextUtils.equals("123",password)){
                    listener.loginSucceeded();
                }else {
                    listener.loginFailed();
                }
            }
        },2000);
    }
}
