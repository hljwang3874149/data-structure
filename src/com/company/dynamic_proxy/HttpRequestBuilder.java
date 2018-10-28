package com.company.dynamic_proxy;

import java.util.concurrent.ConcurrentHashMap;

public class HttpRequestBuilder {
    private String url;
    private ConcurrentHashMap<String, String> paramter = new ConcurrentHashMap<>();

    public HttpRequestBuilder(String url) {
        this.url = url;
    }

    public HttpRequestBuilder appendParameters(String key, String value) {
        paramter.put(key, value);
        return this;
    }

    @Override
    public String toString() {
        return "url = " + url + "\n" + paramter.toString();
    }
}
