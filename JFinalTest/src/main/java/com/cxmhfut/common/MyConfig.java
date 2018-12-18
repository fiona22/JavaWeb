package com.cxmhfut.common;

import com.cxmhfut.interceptor.GlobalInterceptor;
import com.cxmhfut.model.Blog;
import com.cxmhfut.route.AdminRoute;
import com.cxmhfut.route.FrontRoute;
import com.cxmhfut.service.ShareMethod;
import com.cxmhfut.service.ShareObject;
import com.jfinal.config.*;
import com.jfinal.ext.handler.ContextPathHandler;
import com.jfinal.kit.PathKit;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.cron4j.Cron4jPlugin;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.plugin.ehcache.EhCachePlugin;
import com.jfinal.template.Engine;

public class MyConfig extends JFinalConfig {
    @Override
    public void configConstant(Constants constants) {
        PropKit.use("config.properties");
        //设置为开发模式
        constants.setDevMode(PropKit.getBoolean("devMode"));
    }

    @Override
    public void configRoute(Routes routes) {
        //routes.add("/", IndexController.class);
        //routes.add("/", IndexController.class, "/abc");
        //routes.add("/blog", BlogController.class, "/blog");
        //routes.add("/user", UserController.class, "/user");
        routes.add(new FrontRoute());
        routes.add(new AdminRoute());
    }

    @Override
    public void configEngine(Engine engine) {
        engine.setBaseTemplatePath(PathKit.getWebRootPath());
        engine.addSharedFunction("/front/common.html");
        engine.addSharedStaticMethod(ShareObject.class);
        engine.addSharedMethod(new ShareMethod());
        engine.addSharedObject("sm",new ShareMethod());
    }

    @Override
    public void configPlugin(Plugins plugins) {
        //配置c3p0数据库连接池插件
        DruidPlugin druidPlugin = new DruidPlugin(PropKit.get("jdbcUrl"), PropKit.get("user"), PropKit.get("password"));

        plugins.add(druidPlugin);

        ActiveRecordPlugin arp = new ActiveRecordPlugin(druidPlugin);

        arp.setBaseSqlTemplatePath(PathKit.getWebRootPath()+"/WEB-INF");
        arp.addSqlTemplate("sql/demo.sql");

        arp.addMapping("t_blog", Blog.class);
        plugins.add(arp);

        //缓存插件
        plugins.add(new EhCachePlugin());

        //任务调度插件
        Cron4jPlugin cron4jPlugin = new Cron4jPlugin("cron4j.properties","cron4j");
        plugins.add(cron4jPlugin);
    }

    @Override
    public void configInterceptor(Interceptors interceptors) {
        interceptors.add(new GlobalInterceptor());
        //interceptors.addGlobalServiceInterceptor(new InjectInterceptor());//给所有的Service添加拦截器
    }

    @Override
    public void configHandler(Handlers handlers) {
        //创建上下文
        handlers.add(new ContextPathHandler("ctx"));
    }

    @Override
    public void afterJFinalStart() {
        super.afterJFinalStart();
        System.out.println("afterJFinalStart...");
    }

    @Override
    public void beforeJFinalStop() {
        super.beforeJFinalStop();
        System.out.println("beforeJFinalStop...");
    }
}
