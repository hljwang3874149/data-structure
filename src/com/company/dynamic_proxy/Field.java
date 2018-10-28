package com.company.dynamic_proxy;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
public @interface Field {
    String value();

    boolean encoded() default false;
}
