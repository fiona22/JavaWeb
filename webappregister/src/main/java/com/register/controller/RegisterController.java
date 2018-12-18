package com.register.controller;

import com.jfinal.core.Controller;
import com.register.model.User;

public class RegisterController extends Controller {
    public void register(){
        renderTemplate("register.html");

    }

    public void doRegister() {
        String usrname = getPara("username");//获取用户输入的用户名和密码
        String psword = getPara("password");
        String pswordAgain = getPara("password2");//再次输入密码，确保两次相同

        String sql = "insert into user values(?, ?)";
        // User user = User.dao.findFirst(sql,usrname);
        if (psword == pswordAgain) {
            renderTemplate("注册成功");
        } else {
            renderText("密码不一致请重新输入");
        }

    }

}
