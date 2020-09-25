package com.yejing.exercise.proxy;

import java.lang.reflect.Proxy;

public class ProxyFactory<T> {
    private final Class<T> mapperInterface;

    public ProxyFactory(Class<T> mapperInterface) {
        this.mapperInterface = mapperInterface;
    }

    @SuppressWarnings("unchecked")
    protected T newInstance(ProxyHandler<T> mapperProxy) {
        return (T)Proxy.newProxyInstance(mapperInterface.getClassLoader(),new Class[]{mapperInterface}, mapperProxy);
    }
}
