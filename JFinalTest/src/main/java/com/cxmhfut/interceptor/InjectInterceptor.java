package com.cxmhfut.interceptor;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;

public class InjectInterceptor implements Interceptor {
    @Override
    public void intercept(Invocation invocation) {
        System.out.println("Inject Interceptor...");
        invocation.invoke();
    }
}
