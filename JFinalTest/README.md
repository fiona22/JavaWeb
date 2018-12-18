# JFinalTest

##项目搭建过程
- maven镜像配置
```xml
<mirror>
    <id>alimaven</id>
    <name>aliyun maven</name>
    <url>http://maven.aliyun.com/nexus/content/groups/public/</url>
    <mirrorOf>central</mirrorOf>        
</mirror>
```
- pom.xml中配置填写JFinal的相关依赖描述
```xml
<dependencies>
    <dependency>
      <groupId>com.jfinal</groupId>
      <artifactId>jfinal</artifactId>
      <version>3.1</version>
      <scope>compile</scope>
    </dependency>
    <dependency>
      <groupId>com.jfinal</groupId>
      <artifactId>jetty-server</artifactId>
      <version>8.1.8</version>
      <!--
      此处的 scope 值为 compile 仅为支持 IDEA 下启动项目
      打 war 包时需要改成 provided，以免将一些无用的 jar 打进去
      -->
      <scope>compile</scope>
    </dependency>
</dependencies>
```
- 创建MyConfig配置类
- web.xml中进行MyConfig的配置
```xml
<web-app>
    <display-name>Archetype Created Web Application</display-name>

    <filter>
        <filter-name>jfinal</filter-name>
        <filter-class>com.jfinal.core.JFinalFilter</filter-class>
        <init-param>
            <param-name>configClass</param-name>
            <param-value>com.cxmhfut.common.MyConfig</param-value>
        </init-param>
    </filter>

    <filter-mapping>
        <filter-name>jfinal</filter-name>
        <url-pattern>/*</url-pattern>
    </filter-mapping>
</web-app>
```
- 建立Controller并继承自JFinal的Controller
- 编写JFinal的启动方法，并启动项目
- 浏览器中输入访问地址

## Interceptor分类

- Method Interceptor 方法级别
- Class Interceptor 类级别
- Router Interceptor 路由级别
- Global Interceptor 全局拦截
- Inject Interceptor 业务注入拦截器，对指定需要被注入的方法有效，可以是整个业务类，也可以是某个方法

拦截器栈，多个Interceptor组合使用的拦截器

## Interceptor的优先级别

- 1 GlobalInterceptor
- 2 InjectInterceptor(InjectInterceptor RouteInterceptor)
- 3 ClassInterceptor
- 4 MethodInterceptor