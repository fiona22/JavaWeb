package com.register.route;

import com.jfinal.config.Routes;
import com.register.controller.RegisterController;
import com.register.interceptor.FrontRouteInterceptor;

public class AdminRoute extends Routes {

    @Override
    public void config() {
        setBaseViewPath("/WEB-INF");
        addInterceptor(new FrontRouteInterceptor());
        add("/admin", RegisterController.class);


    }
}
