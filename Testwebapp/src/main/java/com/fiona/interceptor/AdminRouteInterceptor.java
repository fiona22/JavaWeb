package com.fiona.interceptor;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;


public class AdminRouteInterceptor implements Interceptor {
    @Override
    public void intercept(Invocation invocation) {
        System.out.println("AdminRouteInterceptor...");
        invocation.invoke(); //very important and must be invoked

    }
}
