package com.cxmhfut.interceptor;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;

public class FrontRouteInteceptor implements Interceptor {
    @Override
    public void intercept(Invocation invocation) {
        System.out.println("Front intercept...");
        invocation.invoke();
    }
}
