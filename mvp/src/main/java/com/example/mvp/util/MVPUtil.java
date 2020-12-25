package com.example.mvp.util;

import java.lang.reflect.ParameterizedType;

/**
 * Created by fan.zx
 * Date: 2020/12/22 15:07
 * Describe:
 */
public class MVPUtil {
    /**
     * ParameterizedType：参数化类型，即泛型
     * getClass()：获取该类的类型类
     * getGenericSuperclass()：获得带有泛型的父类
     * getActualTypeArguments()[i]:从一个泛型类型中获取第i个泛型参数的类型类。
     * @param o
     * @param i 第几个参数
     * @param <T>
     * @return  新构建的实例
     */
    public static <T> T getT(Object o, int i) {
        try {
            return ((Class<T>) ((ParameterizedType)(o.getClass().getGenericSuperclass())).getActualTypeArguments()[i]).newInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return null;
    }
}
