package com.example.mvp;

/**
 * Created by fan.zx
 * Date: 2020/12/21 15:51
 * Describe:P层和View层的交互
 */
public interface LoginView {
    void showLoading();
    void hideLoading();
    void success();
    void failed();
    void clear();
}
