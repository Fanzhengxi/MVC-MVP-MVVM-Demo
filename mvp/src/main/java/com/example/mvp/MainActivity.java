package com.example.mvp;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mvp.base.BaseActivity;
import com.example.mvp.presenter.LoginPresenter;

/**
 * 逻辑处理都在Presenter层
 * 未封装的MVP架构包括：
 * model包，presenter包，LoginView，MainActivity
 */
public class MainActivity extends AppCompatActivity implements LoginView {
    private EditText etUsername,etPassword;
    private ProgressDialog progressDialog;
    private LoginPresenter loginPresenter;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        etUsername=findViewById(R.id.et_account);
        etPassword=findViewById(R.id.et_password);
        //进度条
        progressDialog=new ProgressDialog(this);
        progressDialog.setMessage("登录中，请稍后...");
        progressDialog.setCancelable(false);

        loginPresenter=new LoginPresenter(this,this);
    }

    /**
     * 取消按钮
     * @param view
     */
    public void onCancel(View view) {
        loginPresenter.clear();
    }

    /**
     * 登录按钮
     * @param view
     */
    public void onLogin(View view) {
        loginPresenter.login(etUsername.getText().toString(),etPassword.getText().toString());
    }

    @Override
    public void showLoading() {
        if(progressDialog!=null && !progressDialog.isShowing()){//不在展示中
            progressDialog.show();
        }
    }

    @Override
    public void hideLoading() {
        if (progressDialog!=null &&progressDialog.isShowing()){
            progressDialog.dismiss();
        }

    }

    @Override
    public void success() {
        Toast.makeText(this,"登录成功",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void failed() {
        Toast.makeText(this,"登陆失败",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void clear() {
       etUsername.setText("");
       etPassword.setText("");
    }
}