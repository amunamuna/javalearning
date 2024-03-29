package com.nadou.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName AnnotationDemo
 * @Description TODO
 * @Author amunamuna
 * @Date 2021/7/5 2:17 下午
 * @Version 1.0
 **/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SimpleAnnotation {
    String value();
}
