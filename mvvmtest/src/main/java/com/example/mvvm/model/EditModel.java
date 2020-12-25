package com.example.mvvm.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.library.baseAdapters.BR;

/**
 * Created by fan.zx
 * Date: 2020/12/24 9:48
 * Describe:
 */
public class EditModel extends BaseObservable {
    private String text;
    @Bindable
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
        notifyPropertyChanged(BR.text);
    }
}
