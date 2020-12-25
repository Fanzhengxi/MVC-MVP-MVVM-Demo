package com.example.mvc;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.mvc.model.UserLoginListener;
import com.example.mvc.model.UserLoginModel;
import com.example.mvc.model.UserLoginModelImpl;
import com.example.mvc.utils.ToastUtil;


/**
 * mvc中的Control层，一般是Activity,fragment
 */
public class MainActivity extends AppCompatActivity {
    private UserLoginModel loginModel;
    private EditText etAccount, etPassWord;
    private String account, password;
    private ProgressDialog progressDialog;
    private final String TAG = getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        etAccount = findViewById(R.id.et_account);
        etPassWord = findViewById(R.id.et_password);
        loginModel = new UserLoginModelImpl();
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("登录中，请稍后...");
        progressDialog.setCancelable(false);
    }

    /**
     * 监听就是监听某个方法的执行结果，将监听接口作为参数放在这个方法中。
     *
     * @param view
     */
    public void onLogin(View view) {
        //进度提示
        account = etAccount.getText().toString();
        password = etPassWord.getText().toString();
        if (TextUtils.isEmpty(account) || TextUtils.isEmpty(password)) {
            ToastUtil.toast(MainActivity.this, "请输入您的用户名和密码");
        } else {
            progressDialog.show();
            loginModel.login(account, password, new UserLoginListener() {
                @Override
                public void loginSuccess() {
                    progressDialog.dismiss();//关闭进度条
                    Log.d(TAG, "登录成功！");
                    ToastUtil.toast(MainActivity.this, "登录成功！");
                }

                @Override
                public void loginFiled() {
                    progressDialog.dismiss();//关闭进度条
                    Log.d(TAG, "登录失败!");
                    ToastUtil.toast(MainActivity.this, "登陆失败！");
                }
            });
        }
    }

    public void onCancel(View view) {
        etAccount.setText("");
        etPassWord.setText("");
    }
}