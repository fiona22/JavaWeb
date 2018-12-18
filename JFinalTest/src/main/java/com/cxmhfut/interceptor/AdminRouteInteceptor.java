package com.cxmhfut.interceptor;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;

public class AdminRouteInteceptor implements Interceptor {
    @Override
    public void intercept(Invocation invocation) {
        System.out.println("Admin intercept...");
        invocation.invoke();//一定要调用
    }
}
