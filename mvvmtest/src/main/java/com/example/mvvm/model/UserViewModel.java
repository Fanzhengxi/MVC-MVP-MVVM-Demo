package com.example.mvvm.model;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.example.mvvm.EditActivity;

/**
 * Created by fan.zx
 * Date: 2020/12/23 10:50
 * Describe:
 */
public class UserViewModel {
//    private UserModel userModel;
    private UserModel2 userModel;
    private UserModel3 userModel3;
    private Context mContext;
//
//    public UserViewModel(Context context, UserModel userModel) {
//        this.mContext = context;
//        this.userModel = userModel;
//    }
    public UserViewModel(Context context, UserModel2 userModel,UserModel3 userModel3) {
        this.mContext = context;
        this.userModel = userModel;
        this.userModel3=userModel3;
    }

    public UserModel3 getUserModel3() {
        return userModel3;
    }

    public void setUserModel3(UserModel3 userModel3) {
        this.userModel3 = userModel3;
    }

    /**
     * 展示名字
     */
    public void showName(){
        Toast.makeText(mContext,userModel.getName(),Toast.LENGTH_SHORT).show();
    }
    public void update(){
        userModel.setName("我是实现Observable更新的数据");
    }
    public void update2(){
        userModel.setName("继承BaseObservable更新的数据");
    }
    public void update3(){
        userModel3.describe.set("ObservableField更新的数据");
    }
    public void toEditActivity(){
        userModel.toEditActivity(mContext);
    }
    public void toRecycleActivity(){userModel.toRecycleActivity(mContext);}
}
