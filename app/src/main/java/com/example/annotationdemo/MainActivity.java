package com.example.annotationdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.annotationdemo.runtime.AnnotationClass;
import com.example.annotationdemo.runtime.AnnotationField;
import com.example.annotationdemo.runtime.BindView;

import java.lang.reflect.Field;

@AnnotationClass(name = "张三", id = 2000)
public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tv_content)
    private TextView tv_content;

    @AnnotationField("李四")
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Butterknife.init(this);
//        tv_content = findViewById(R.id.tv_content);

        tv_content.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                getClassAnnotation();

//                getFieldAnnotation();

                //实现Butterknife
                Toast.makeText(MainActivity.this, "再点我试试", Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * 获取类注解
     */
    private void getClassAnnotation() {
        // 这个类是否使用了AnnotationClass这个注解
        boolean hasAnnotation = MainActivity.class.isAnnotationPresent(AnnotationClass.class);
        if (hasAnnotation) {
            //获取到AnnotationClass对象
            AnnotationClass annotationClass = MainActivity.class.getAnnotation(AnnotationClass.class);
            String name = annotationClass.name();
            int id = annotationClass.id();
            tv_content.setText("name：" + name + "，id：" + id);
        }
    }

    /**
     * 获取成员变量的注解
     */
    private void getFieldAnnotation() {
        //获取成员变量的注解
        try {
            Field field = MainActivity.class.getDeclaredField("name");
            //msg成员变量为private,故必须进行此操作
            field.setAccessible(true);
            AnnotationField check = field.getAnnotation(AnnotationField.class);
            //这里把注解的内容赋值给变量
            name = check.value();
            tv_content.setText("name：" + name);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}