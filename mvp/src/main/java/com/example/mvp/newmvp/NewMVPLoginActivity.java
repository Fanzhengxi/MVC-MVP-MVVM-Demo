package com.example.mvp.newmvp;

import android.app.ProgressDialog;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mvp.R;
import com.example.mvp.base.BaseActivity;
import com.example.mvp.presenter.LoginPresenter;

/**
 * Created by fan.zx
 * Date: 2020/12/22 15:47
 * Describe:mvp解耦，构建NewMVPLoginActivity和MainActivity做对比
 * 封装的MVP架构：base包，newmvp包，util包
 * 总结：
 * 第一步：新建base包，新建抽象类BasePresenter,接口BaseModel,BaseView
 * 第二步：在BasePresenter中将model和view绑定
 * 第三步：新建BaseActivity
 * 第四步：建立契约类LoginContract,分别建立Model,View,Presenter继承自他们的Base类
 * 第五步:实现NewMVPActivity
 */
public class NewMVPLoginActivity extends BaseActivity<NewLoginPresenter, NewLoginModel> implements LoginContract.View {
    private EditText etUsername, etPassword;
    private ProgressDialog progressDialog;

    @Override
    protected void initPresenter() {
        presenter.setViewAndModel(this, model);//presenter在BaseActivity的onCreate中实例化了，所以这里直接用

    }

    @Override
    protected int initLayout() {
        return R.layout.activity_main;
    }

    /**
     * 取消按钮
     *
     * @param view
     */
    public void onCancel(View view) {
        presenter.clear();
    }

    /**
     * 登录按钮
     *
     * @param view
     */
    public void onLogin(View view) {
        presenter.rxLogin(etUsername.getText().toString(), etPassword.getText().toString());

//        presenter.login(etUsername.getText().toString(), etPassword.getText().toString());
    }

    @Override
    protected void initView() {
        etUsername = findViewById(R.id.et_account);
        etPassword = findViewById(R.id.et_password);
        //进度条
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("登录中，请稍后...");
        progressDialog.setCancelable(false);

    }

    @Override
    protected void initListener() {

    }

    @Override
    public void showLoading() {
        if (progressDialog != null && !progressDialog.isShowing()) {//不在展示中
            progressDialog.show();
        }
    }

    @Override
    public void hideLoading() {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }

    @Override
    public void success() {
        Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void failed() {
        Toast.makeText(this, "登录失败", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void clear() {
        etUsername.setText("");
        etPassword.setText("");
    }

}
