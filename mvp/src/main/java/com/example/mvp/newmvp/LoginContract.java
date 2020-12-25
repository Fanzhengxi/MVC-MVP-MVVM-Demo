package com.example.mvp.newmvp;

import com.example.mvp.base.BaseModel;
import com.example.mvp.base.BasePresenter;
import com.example.mvp.base.BaseView;
import com.example.mvp.model.UserLoginListener;

import io.reactivex.Observable;


/**
 * Created by fan.zx
 * Date: 2020/12/22 15:49
 * Describe:契约类
 * 优点：当有新的业务逻辑时，在这里的接口添加即可
 */
public class LoginContract {
    interface Model extends BaseModel{
        //可拓展
        //三方登录
//        void thirdLogin(String username, String password, UserLoginListener userLoginListener);
        void login(String username, String password, UserLoginListener userLoginListener);
        Observable<String> rxLogin(String username, String password);
    }
    interface View extends BaseView{
        void showLoading();
        void hideLoading();
        void success();
        void failed();
        void clear();
    }

    /**
     * 控制
     */
    abstract static class Presenter extends BasePresenter<View,Model>{
       abstract void login(String username,String password);
       abstract void rxLogin(String username,String password);
       abstract void clear();;
    }

}
