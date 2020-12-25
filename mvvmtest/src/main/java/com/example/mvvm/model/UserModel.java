package com.example.mvvm.model;

import android.widget.ImageView;

import androidx.databinding.Bindable;
import androidx.databinding.BindingAdapter;
import androidx.databinding.Observable;
import androidx.databinding.PropertyChangeRegistry;

import com.bumptech.glide.Glide;
import com.example.mvvm.BR;

/**
 * Created by fan.zx
 * Date: 2020/12/23 10:43
 * Describe:
 */
public class UserModel  implements Observable {
    private String name;
    private int userPhoto;
    private transient PropertyChangeRegistry propertyChangeRegistry=new PropertyChangeRegistry();
    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyChange(BR.name);//BR是在getName()上加上 @Bindable注解才有的
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

    @Override
    public void addOnPropertyChangedCallback(OnPropertyChangedCallback callback) {
        if (propertyChangeRegistry==null){
            propertyChangeRegistry=new PropertyChangeRegistry();
        }
        propertyChangeRegistry.add(callback);

    }

    @Override
    public void removeOnPropertyChangedCallback(OnPropertyChangedCallback callback) {
        if (propertyChangeRegistry!=null){
            propertyChangeRegistry.remove(callback);
        }
    }
    private void notifyChange(int propertyId){
        if (propertyChangeRegistry==null){
            propertyChangeRegistry=new PropertyChangeRegistry();
        }
        propertyChangeRegistry.notifyChange(this,propertyId);
    }
}
