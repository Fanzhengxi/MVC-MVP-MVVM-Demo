package com.example.mvp.presenter;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;

import com.example.mvp.LoginView;
import com.example.mvp.MainActivity;
import com.example.mvp.model.UserLoginListener;
import com.example.mvp.model.UserLoginModel;
import com.example.mvp.model.UserLoginModelImpl;

/**
 * Created by fan.zx
 * Date: 2020/12/21 16:05
 * Describe:执行逻辑都放在Presenter层
 */
public class LoginPresenter {
    private LoginView loginView;
    private UserLoginModel userLoginModel;
    private Context context;

    public LoginPresenter(Context context, MainActivity loginView) {
        this.loginView = loginView;
        this.context=context;
        userLoginModel = new UserLoginModelImpl();
    }

    /**
     * 登录结果如何通知Activity呢？
     *
     * @param username
     * @param password
     */
    public void login(String username, String password) {
        if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)){
            Toast.makeText(context,"请您输入用户名和密码",Toast.LENGTH_SHORT).show();;
        }else {
            loginView.showLoading();
            userLoginModel.login(username, password, new UserLoginListener() {
                @Override
                public void loginSucceeded() {
                    loginView.success();
                    loginView.hideLoading();
                }

                @Override
                public void loginFailed() {
                    loginView.failed();
                    loginView.hideLoading();
                }
            });
        }
    }
    public void clear(){
       loginView.clear();
    }
}
