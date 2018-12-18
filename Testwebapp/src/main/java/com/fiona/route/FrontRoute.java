package com.fiona.route;

import com.fiona.controller.IndexController;
import com.fiona.interceptor.FrontRouteInterceptor;
import com.jfinal.config.Routes;
/**
 * 前端路由配置都放在这里
 */
public class FrontRoute extends Routes {

    @Override
    public void config() {

        setBaseViewPath("/front");
        addInterceptor(new FrontRouteInterceptor());//路由级别的拦截器
        add("/", IndexController.class);
    }
}
