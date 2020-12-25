package com.example.mvvm.recycle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.example.mvvm.R;
import com.example.mvvm.databinding.ActivityRecycleBinding;

import java.util.ArrayList;
import java.util.List;

public class RecycleActivity extends AppCompatActivity {
    private ActivityRecycleBinding activityRecycleBinding;
    private RecycleAdapter adapter;
//    private List<TestBean> testBeanList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_recycle);
        activityRecycleBinding= DataBindingUtil.setContentView(this,R.layout.activity_recycle);
        //设置recycleview为纵向布局
        activityRecycleBinding.recycleview.setLayoutManager(new LinearLayoutManager(this));
        //将数据传入adapter中
        adapter=new RecycleAdapter(this,TestBean.getData());
        activityRecycleBinding.recycleview.setAdapter(adapter);
    }
}