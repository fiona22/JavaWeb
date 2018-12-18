package com.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//@RequestMapping("/") 含义 请求会调用userQuery()方法
//返回的fiona字符串会被上文提到的内部视图解析器
//进行前后缀拼接成 /WEB-INF/jsp/login.jsp 最终返回登录页面

@Controller
@RequestMapping("/")
public class DispatcherController {
    @RequestMapping("/")
    public String userQuery(){
        return "fiona";
    }

}
