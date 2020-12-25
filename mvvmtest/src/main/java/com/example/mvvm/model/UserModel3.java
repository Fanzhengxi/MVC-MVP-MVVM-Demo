package com.example.mvvm.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.ObservableField;

/**
 * Created by fan.zx
 * Date: 2020/12/23 16:17
 * Describe:
 * 使用ObservableField实现数据更新步骤：
 * step1：
 * 新建UserModel3继承BaseObservable，new一个ObservableField的实例。
 * step2:
 * 在UserViewModel的构造方法中绑定UserModel3，新建update3{调用describe.set("更新的内容")}来更新数据
 * step3：
 * 另textView显示describe的内容。
 *            android:text="@{usermodel3.describe}"
 * step4：在MainActivity中绑定数据
 *  UserModel3 userModel3=new UserModel3();
 *         userModel3.describe.set("我是开始的描述");
 *         mainBinding.setUsermodel3(userModel3);
 *
 */
public class UserModel3 extends BaseObservable {
    public ObservableField<String> describe=new ObservableField<>();
}
