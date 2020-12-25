package com.example.mvp.newmvp;

import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;

import com.example.mvp.model.UserLoginListener;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.annotations.NonNull;


/**
 * Created by fan.zx
 * Date: 2020/12/22 16:24
 * Describe:等效于UserLoginModelImpl
 */
public class NewLoginModel implements LoginContract.Model {
    @Override
    public void login(String username, String password, UserLoginListener userLoginListener) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (TextUtils.equals("jike",username) && TextUtils.equals("123",password)){
                    userLoginListener.loginSucceeded();
                }else {
                    userLoginListener.loginFailed();
                }
            }
        },2000);
    }

    @Override
    public Observable<String> rxLogin(String username, String password) {
        //rxjava库已经弃用了
//        return Observable.create(new Observable.OnSubscribe<String>() {
//            @Override
//            public void call(Subscriber<? super String> subscriber) {
//                SystemClock.sleep(2000);
//                if (TextUtils.equals("jike",username) && TextUtils.equals("123",password)){
//                    subscriber.onNext("SUCCESS!");//发射
//                    subscriber.onCompleted();
//                }else {
//                    subscriber.onNext("FAIL!");
//                    subscriber.onCompleted();
//                }
//            }
//        });
        return Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<String> emitter) throws Exception {
                SystemClock.sleep(2000);
                if (TextUtils.equals("jike",username) && TextUtils.equals("123",password)){
                    emitter.onNext("SUCCESS!");//发射
                    emitter.onComplete();
                }else {
                    emitter.onNext("FAIL!");
                    emitter.onComplete();
                }
            }
        });
    }
}
