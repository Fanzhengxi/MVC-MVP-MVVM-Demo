package com.example.mvvm;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.mvvm.databinding.ActivityMainBinding;
import com.example.mvvm.model.UserModel2;
import com.example.mvvm.model.UserModel3;
import com.example.mvvm.model.UserViewModel;

/**
 * 在这里添加数据
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        //绑定view
        ActivityMainBinding mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
//        UserModel userModel=new UserModel();
        UserModel2 userModel = new UserModel2();
        userModel.setName("Jessie");
        userModel.setUserPhoto(R.mipmap.dora);
        mainBinding.setUsermodel(userModel);//给activity_main.xml传值


        //ObservableFiled实现数据更新
        UserModel3 userModel3=new UserModel3();
        userModel3.describe.set("我是开始的描述");
        mainBinding.setUsermodel3(userModel3);
        //绑定点击事件
        UserViewModel userViewModel = new UserViewModel(this, userModel,userModel3);
        mainBinding.setUserviewmodel(userViewModel);
    }
}