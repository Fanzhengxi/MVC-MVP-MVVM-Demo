package com.example.mvc.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by fan.zx
 * Date: 2020/12/18 17:05
 * Describe:
 */
public class ToastUtil {
    public static void toast(Context context,String message){
        Toast.makeText(context,message,Toast.LENGTH_SHORT).show();
    }
}
