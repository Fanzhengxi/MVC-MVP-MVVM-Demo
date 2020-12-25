package com.example.mvvm.model;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.Toast;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.library.baseAdapters.BR;

import org.w3c.dom.Text;

/**
 * Created by fan.zx
 * Date: 2020/12/25 9:47
 * Describe:
 */
public class LoginModel extends BaseObservable {
    private String name;
    private String password;

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    @Bindable
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        notifyPropertyChanged(BR.password);
    }

    public void login(Context context, ProgressDialog progressDialog) {
        if (TextUtils.isEmpty(name) || TextUtils.isEmpty(password)) {
            Toast.makeText(context, "请您输入用户名和密码！", Toast.LENGTH_SHORT).show();
        }else{
            progressDialog.show();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (TextUtils.equals("jike",name) && TextUtils.equals("123",password)){
                        progressDialog.dismiss();
                        Toast.makeText(context, "登陆成功！", Toast.LENGTH_SHORT).show();
                    }else {
                        progressDialog.dismiss();
                        Toast.makeText(context, "登录失败！", Toast.LENGTH_SHORT).show();
                    }
                }
            },2000);
        }
    }
}
