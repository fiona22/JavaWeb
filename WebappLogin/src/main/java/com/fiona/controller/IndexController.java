package com.fiona.controller;
import com.fiona.model.User;
import com.jfinal.core.Controller;

public class IndexController extends Controller {
    /**
     * action定义的模板，必须是public和void类型
     */
    public void index() {
        String msg = getPara("msg", "DefaultMsg");
        String[] v = getParaValues("test"); //checkbox
        setAttr("msg", "HELLO, JFINAL3.0---->" + msg);
        //getModel(Blog.class); //getModel用法
        renderTemplate("index.html"); //声明渲染到index.html
    }

    public void login() {
        renderTemplate("login.html"); //声明渲染到login.html
    }

    public void doLogin() { //处理login行为
        String username = getPara("username");
        String password = getPara("password");

        String sql = "select * from user where username = ?";

        User user = User.dao.findFirst(sql, username);

        if (user == null) {
            renderText("用户不存在");
        } else if (user.getPassword().equals(password)) {
            renderText("登陆成功");
        } else {
            renderText("密码错误");
        }

    }


}
