package com.fiona.interceptor;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;

public class FrontRouteInterceptor implements Interceptor {

    @Override
    public void intercept(Invocation invocation) {
        System.out.println("FrontRouteInterceptor...");
        invocation.invoke(); //very important and must be invoked

    }
}
