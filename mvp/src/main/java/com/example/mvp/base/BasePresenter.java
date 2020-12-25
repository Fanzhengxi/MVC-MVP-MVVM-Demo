package com.example.mvp.base;

import android.content.Context;

/**
 * Created by fan.zx
 * Date: 2020/12/21 16:57
 * Describe:抽象泛型类来封装，MVP解耦
 * presenter绑定view和model,在BasePresenter的子类中就可以使用view和model的实例了，进而调用他们的方法，使presenter起到逻辑控制的作用。
 * @param <T> View
 * @param <E> Model 数据，集合
 */
public abstract class BasePresenter <T,E>{
    public Context mContext;
    public T mView;
    public E mModel;
    public void setViewAndModel(T view,E model){
        this.mView=view;
        this.mModel=model;
    }
    //Rxjava用到
//    public void onStart(){}
//    public void onDestroy(){}
}
