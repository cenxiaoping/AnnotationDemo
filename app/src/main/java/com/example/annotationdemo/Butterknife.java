package com.example.annotationdemo;

import android.app.Activity;

import com.example.annotationdemo.runtime.BindView;

import java.lang.reflect.Field;

import androidx.annotation.NonNull;

/**
 * 运行时注解实现 ButterkNife
 */
public class Butterknife {
    public static void init(@NonNull Activity activity) {
        //获得成员变量
        Field[] fields = activity.getClass().getDeclaredFields();
        for (Field field : fields) {
            //允许修改反射属性
            field.setAccessible(true);
            //获取到标签
            BindView viewId = field.getAnnotation(BindView.class);
            if (viewId != null) {
                try {
                    //向对象的这个Field属性设置新值value
                    field.set(activity, activity.findViewById(viewId.value()));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}