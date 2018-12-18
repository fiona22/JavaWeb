package com.register.common;

import com.jfinal.config.*;
import com.jfinal.ext.handler.ContextPathHandler;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.template.Engine;
import com.register.model._MappingKit;
import com.register.route.AdminRoute;
import com.register.route.FrontRoute;

public class RegisterConfig extends JFinalConfig {
    @Override
    public void configConstant(Constants constants) {
        constants.setDevMode(true);
        PropKit.use("db.properties"); //use this database
    }

    @Override
    public void configRoute(Routes routes) {
        routes.add(new FrontRoute());
        routes.add(new AdminRoute());

    }

    @Override
    public void configEngine(Engine engine) {

    }

    @Override
    public void configPlugin(Plugins plugins) {
        //连接池
        DruidPlugin dp = new DruidPlugin(PropKit.get("jdbcurl"),PropKit.get("user"),PropKit.get("password"));
        plugins.add(dp);
        ActiveRecordPlugin arp = new ActiveRecordPlugin(dp);
        plugins.add(arp);
        _MappingKit.mapping(arp);
    }

    @Override
    public void configInterceptor(Interceptors interceptors) {


    }

    @Override
    public void configHandler(Handlers handlers) {
        handlers.add(new ContextPathHandler("ctx"));


    }
}
