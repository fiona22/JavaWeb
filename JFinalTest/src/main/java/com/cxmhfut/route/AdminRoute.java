package com.cxmhfut.route;

import com.cxmhfut.controller.AdminController;
import com.cxmhfut.interceptor.AdminRouteInteceptor;
import com.jfinal.config.Routes;

/**
 * 后端路由配置
 */
public class AdminRoute extends Routes {

    @Override
    public void config() {
        setBaseViewPath("/WEB-INF");
        addInterceptor(new AdminRouteInteceptor());
        add("/admin", AdminController.class);
    }
}
