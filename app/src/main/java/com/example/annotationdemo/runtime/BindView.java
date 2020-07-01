package com.example.annotationdemo.runtime;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 简  述
 * 作  者  chenxiaoping
 * 包  名  com.example.annotationdemo
 * 时  间  2020/7/1 10:52
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface BindView {
    int value() default -1;
}
