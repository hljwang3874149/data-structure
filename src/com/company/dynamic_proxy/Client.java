package com.company.dynamic_proxy;

import com.company.linklist.LinkedList;

import javax.annotation.PostConstruct;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Client {
    interface Api {
        @POST("/path/value")
        void showNewMessage(@Field("time") long timeStamp, @Field("uid") int id);
    }

    public static void main(String[] args) {
        Api api = (Api) Proxy.newProxyInstance(Client.class.getClassLoader(), new Class[]{Api.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                HttpRequestBuilder builder = null;
                LinkedList<String> keys = new LinkedList<>();
                LinkedList<String> values = new LinkedList<>();

                for (Annotation annotation : method.getAnnotations()) {
                    if (annotation instanceof POST) {
                        System.out.println(((POST) annotation).value());
                        builder = new HttpRequestBuilder(((POST) annotation).value());
                    }
                }
                for (int i = 0; i < method.getParameterAnnotations().length; i++) {

                    System.out.println("i = " + i);
                    for (Annotation annotation : method.getParameterAnnotations()[i]) {
                        if (annotation instanceof Field) {
                            System.out.println(((Field) annotation).value());
                            keys.addFirst(((Field) annotation).value());
                        }

                    }

                }
                for (Object arg : args) {
                    System.out.println(arg);
                    values.addFirst(String.valueOf(arg));
                }
                while (keys.getSize() > 0) {
                    if (null != builder)
                        builder.appendParameters(keys.remove(0), values.remove(0));
                }
                System.out.println(builder.toString());

                return null;
            }
        });
        api.showNewMessage(System.currentTimeMillis(), 1323);

    }
}
