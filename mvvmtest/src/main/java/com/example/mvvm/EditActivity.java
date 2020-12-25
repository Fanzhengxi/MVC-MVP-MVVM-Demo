package com.example.mvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.widget.EditText;

import com.example.mvvm.databinding.ActivityEditBinding;
import com.example.mvvm.model.EditModel;
import com.example.mvvm.model.EditViewModel;

public class EditActivity extends AppCompatActivity {

    /**
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_edit);
        //注意ActivityEditBinding要写对
        ActivityEditBinding activityEditBinding= DataBindingUtil.setContentView(this,R.layout.activity_edit);
        EditModel editModel=new EditModel();
//        editModel.setText("123");
        editModel.setText("");
        activityEditBinding.setEditmodel(editModel);
        EditViewModel editViewModel=new EditViewModel(this,editModel);
        activityEditBinding.setEditviewmodel(editViewModel);
//可以直接调用控件的id,而不需要findViewById,入如：直接使用Button
        activityEditBinding.button.setText("特殊变量id");
//        new EditText().addTextChangedListener();
    }
}