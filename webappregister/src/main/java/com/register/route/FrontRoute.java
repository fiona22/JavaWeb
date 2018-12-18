package com.register.route;

import com.jfinal.config.Routes;
import com.register.controller.RegisterController;
import com.register.interceptor.FrontRouteInterceptor;

public class FrontRoute extends Routes {
    @Override
    public void config() {

        setBaseViewPath("/front");//设置基本路径
        addInterceptor(new FrontRouteInterceptor());//路由级别的拦截器
        add("/",RegisterController.class);

    }
}
