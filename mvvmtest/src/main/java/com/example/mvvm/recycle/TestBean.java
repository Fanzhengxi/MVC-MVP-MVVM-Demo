package com.example.mvvm.recycle;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.library.baseAdapters.BR;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fan.zx
 * Date: 2020/12/24 16:41
 * Describe:
 */
public class TestBean extends BaseObservable {
    private String name;
    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }
    public static List<TestBean> getData(){
        List<TestBean> list=new ArrayList<>();
        for (int i=0;i<10;i++){
            TestBean testBean=new TestBean();
            testBean.setName("John"+i);
            list.add(testBean);
        }
        return list;
    }
}
