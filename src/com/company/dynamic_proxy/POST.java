package com.company.dynamic_proxy;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target(ElementType.METHOD)
public @interface POST {
    String value() default "";
}