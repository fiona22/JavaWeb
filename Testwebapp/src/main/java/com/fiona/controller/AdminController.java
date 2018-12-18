package com.fiona.controller;

import com.jfinal.config.Routes;

public class AdminController extends Routes {
    @Override
    public void config() {
        setBaseViewPath("/WEB-INF");
        add("/admin",IndexController.class);

    }
}
