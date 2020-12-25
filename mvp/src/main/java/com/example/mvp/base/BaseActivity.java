package com.example.mvp.base;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mvp.util.MVPUtil;

/**
 * Created by fan.zx
 * Date: 2020/12/21 17:02
 * Describe:
 */
public abstract class BaseActivity<T extends BasePresenter,E extends BaseModel> extends AppCompatActivity {
    public Context context;
    public T presenter;
    public E model;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(initLayout());
        //建立一个类来获取BaseActivity的实现类
        presenter= MVPUtil.getT(this,0);//获取presenter的实例
        model= MVPUtil.getT(this,1);//获取model的实例
        context=this;
        if (presenter!=null){
            presenter.mContext=this;
        }
        initView();
        initListener();
        initPresenter();
    }

    protected abstract void initPresenter();

    protected abstract int initLayout();
    protected abstract void initView();

    protected abstract void initListener();



}
