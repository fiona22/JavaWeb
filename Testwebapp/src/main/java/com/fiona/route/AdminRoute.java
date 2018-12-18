package com.fiona.route;

import com.fiona.controller.IndexController;
import com.fiona.interceptor.AdminRouteInterceptor;
import com.jfinal.config.Routes;

/**
 * 后端路由配置都放在这里
 */
public class AdminRoute extends Routes {
    @Override
    public void config() {
        setBaseViewPath("/WEB-INF");
        addInterceptor(new AdminRouteInterceptor());//路由级别的拦截器
        add("/admin", IndexController.class);

    }

}
