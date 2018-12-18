package com.cxmhfut.interceptor;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;

public class AInterceptor implements Interceptor {
    @Override
    public void intercept(Invocation invocation) {
        System.out.println("A intercept...");
        invocation.invoke();
    }
}
