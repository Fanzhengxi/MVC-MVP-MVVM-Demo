package com.example.mvvm.model;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;

/**
 * Created by fan.zx
 * Date: 2020/12/24 10:55
 * Describe:
 */
public class EditViewModel {
    private Context context;
    private EditModel editModel;
    public EditViewModel(Context context,EditModel editModel) {
        this.context=context;
        this.editModel=editModel;
    }
    public void changeText(){
        editModel.setText("我改变了");
    }
    //监听编辑框的内容变化
    public TextWatcher editChangeText=new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            editModel.setText(s.toString());
        }
    };
}
