package com.example.mvp.newmvp;

import android.text.TextUtils;
import android.widget.Toast;

import com.example.mvp.model.UserLoginListener;

import org.reactivestreams.Subscriber;

import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by fan.zx
 * Date: 2020/12/22 16:26
 * Describe:
 */
public class NewLoginPresenter extends LoginContract.Presenter {
    /**
     * login方法的控制
     *
     * @param username
     * @param password
     */
    @Override
    void login(String username, String password) {
        if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
            Toast.makeText(mContext, "请您输入用户名和密码", Toast.LENGTH_SHORT).show();
            ;
        } else {
            mView.showLoading();
            mModel.login(username, password, new UserLoginListener() {
                @Override
                public void loginSucceeded() {
                    mView.success();
                    mView.hideLoading();
                }

                @Override
                public void loginFailed() {
                    mView.failed();
                    mView.hideLoading();
                }
            });
        }
    }

    @Override
    void rxLogin(String username, String password) {
        if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
            Toast.makeText(mContext, "请您输入用户名和密码", Toast.LENGTH_SHORT).show();
        } else {
            mView.showLoading();
            mModel.rxLogin(username, password)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<String>() {
                        @Override
                        public void onSubscribe(@NonNull Disposable d) {
                            mView.hideLoading();
                        }

                        @Override
                        public void onNext(@NonNull String s) {
                            mView.hideLoading();
                            Toast.makeText(mContext, s, Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onError(@NonNull Throwable e) {
                            mView.hideLoading();
                        }

                        @Override
                        public void onComplete() {
                            mView.hideLoading();
                        }
                    });
            //rxjava的用法，依赖库已经停用，不能用了
//            mModel.rxLogin(username,password)
//                    .subscribeOn(Schedulers.io())//调度器，
//                    .observeOn(AndroidSchedulers.mainThread())//进去主线程
//                    .subscribe(new Subscriber<String>() {//消费
//                        @Override
//                        public void onCompleted() {
//                            mView.hideLoading();
//
//                        }
//
//                        @Override
//                        public void onError(Throwable e) {
//                            mView.hideLoading();
//
//                        }
//
//                        @Override
//                        public void onNext(String s) {
//                            mView.hideLoading();
//                            Toast.makeText(mContext,s,Toast.LENGTH_SHORT).show();
//
//                        }
//                    });


        }
    }

    @Override
    void clear() {
        mView.clear();
    }
}
