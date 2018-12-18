package com.fiona.common;

import com.fiona.model._MappingKit;
import com.fiona.route.AdminRoute;
import com.fiona.route.FrontRoute;
import com.jfinal.config.*;
import com.jfinal.ext.handler.ContextPathHandler;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.template.Engine;


public class MyConfig extends JFinalConfig {
    @Override
    public void configConstant(Constants constants) {
        PropKit.use("db.properties");
        constants.setDevMode(true);
    }

    // 初步完成路由分包，前端和后端
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
        // 连接池
        DruidPlugin dp = new DruidPlugin(PropKit.get("jdbcUrl"),PropKit.get("user"),PropKit.get("password"));
        plugins.add(dp);
        ActiveRecordPlugin arp = new ActiveRecordPlugin(dp);
        _MappingKit.mapping(arp); //
        plugins.add(arp);

    }

    @Override
    public void configInterceptor(Interceptors interceptors) {

    }

    @Override
    public void configHandler(Handlers handlers) {
        handlers.add(new ContextPathHandler("ctx")); //防止丢失

    }
}
