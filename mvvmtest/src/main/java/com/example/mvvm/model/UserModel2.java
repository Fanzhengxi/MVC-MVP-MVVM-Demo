package com.example.mvvm.model;

import android.content.Context;
import android.content.Intent;
import android.widget.ImageView;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.BindingAdapter;
import androidx.databinding.PropertyChangeRegistry;
import androidx.databinding.library.baseAdapters.BR;

import com.bumptech.glide.Glide;
import com.example.mvvm.EditActivity;
import com.example.mvvm.recycle.RecycleActivity;

/**
 * Created by fan.zx
 * Date: 2020/12/23 10:43
 * Describe:
 * BaseObservable更新数据的实现步骤：
 * step1：
 * UserModel2继承BaseObservable,在需要更新的属性的get方法上加上注解：@Bindable，
 * 在set方法里通知更新
 * step2:
 * 在UserViewModel中写update（）调用set方法更新数据
 * step3:
 * 在控件的onClick方法中调用UserViewModel中开放的数据更新方法
 *             android:onClick="@{(v)->userviewmodel.update()}"
 *
 *
 *BaseObservable中实现了notifyPropertyChanged方法不用再自定义，Observable需要自定义notifyChange方法
 */
public class UserModel2  extends BaseObservable {
    private String name;
    private int userPhoto;
    private transient PropertyChangeRegistry propertyChangeRegistry=new PropertyChangeRegistry();
    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    public int getUserPhoto() {
        return userPhoto;
    }

    public void setUserPhoto(int userPhoto) {
        this.userPhoto = userPhoto;
    }

    @BindingAdapter({"showPhoto"})//这是一个自定义的方法，展示图片
    public static void showPhoto(ImageView imageView, int url) {
        Glide.with(imageView.getContext()).load(url).into(imageView);
    }


    public void toEditActivity(Context mContext) {
        mContext.startActivity(new Intent(mContext, EditActivity.class));
    }
    public void toRecycleActivity(Context context){
        context.startActivity(new Intent(context, RecycleActivity.class));
    }
}
