package com.example.mvvm.viewmodel;
import android.app.ProgressDialog;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Display;
import com.example.mvvm.model.LoginModel;
import java.lang.reflect.Modifier;
/**
 * Created by fan.zx
 * Date: 2020/12/25 9:48
 * Describe:
 */
public class LoginViewModel {
    private Context context;
    private LoginModel loginModel;
    private ProgressDialog progressDialog;
    public LoginViewModel(Context context, LoginModel loginModel) {
        this.context=context;
        this.loginModel= loginModel;
        progressDialog=new ProgressDialog(context);
        progressDialog.setMessage("登录中，请稍后...");
        progressDialog.setCancelable(false);
    }
    public void login(){
        //这里怎么获取EditText中的值
        loginModel.login(context,progressDialog);
    }
    public void clear(){
        loginModel.setName("");
        loginModel.setPassword("");
    }
    public TextWatcher editNameChange =new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }
        @Override
        public void afterTextChanged(Editable s) {
            loginModel.setName(s.toString());
        }
    };
    public TextWatcher editPasswordChange=new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }
        @Override
        public void afterTextChanged(Editable s) {
            loginModel.setPassword(s.toString());
        }
    };
}
