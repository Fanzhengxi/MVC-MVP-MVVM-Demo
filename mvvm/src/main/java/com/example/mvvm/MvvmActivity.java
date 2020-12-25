package com.example.mvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.mvvm.databinding.ActivityMvvmBinding;
import com.example.mvvm.model.LoginModel;
import com.example.mvvm.viewmodel.LoginViewModel;

public class MvvmActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_mvvm);
        ActivityMvvmBinding mvvmBinding= DataBindingUtil.setContentView(this,R.layout.activity_mvvm);
        LoginModel loginModel=new LoginModel();
        mvvmBinding.setLoginmodel(loginModel);
        LoginViewModel loginViewModel=new LoginViewModel(this,loginModel);
        mvvmBinding.setLoginviewmodel(loginViewModel);
    }
}