package com.cxmhfut.service;

import com.cxmhfut.interceptor.InjectInterceptor;
import com.jfinal.aop.Before;

public class ServiceImpl {

    @Before(InjectInterceptor.class)
    public void testInject() {
        System.out.println("testInject");
    }
}
