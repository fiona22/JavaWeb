package com.cxmhfut.route;

import com.cxmhfut.controller.IndexController;
import com.cxmhfut.interceptor.FrontRouteInteceptor;
import com.jfinal.config.Routes;

/**
 * 前端路由配置
 */
public class FrontRoute extends Routes {
    @Override
    public void config() {
        setBaseViewPath("/front");
        addInterceptor(new FrontRouteInteceptor());
        add("/", IndexController.class);
    }
}
