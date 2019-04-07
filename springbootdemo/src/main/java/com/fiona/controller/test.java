package com.fiona.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 这里的@RestController   相当于@ResponseBody + @Controller
 * 注意到，这里有一个main函数，再联想到前面说的，SpringBoot应用一般是打包成可执行jar包来发布的，这个main函数就是整个项目的入口。
 * 而之所以能这么做，是因为SpringBoot连Tomcat8作为一个插件都集成进去了，所以就不必跟之前的SSM架构下一样，
 * 还需要去在Tomcat下配置war包才能运行。直接点击运行该main函数，再浏览器链接栏，输入地址http://localhost:8088/hello，就可以看到打印的字符串”Hello World!”了。
 */
@RestController
public class test {
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String helloSpringBoot(){
        return "Hello SpringBoot!";
    }
}