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
        //System.out.println(user);
        //{password:hello1, id:1, username:fiona}

        if (user == null) {
            renderText("用户不存在");
        } else if (user.getPassword().equals(password)) {
            renderText("登陆成功");
        } else {
            renderText("密码错误");
        }
    }

    public void register() {
        renderTemplate("register.html"); //声明渲染到login.html
    }
    public void doRegister() { //处理register行
        String usrname = getPara("username");
        String passwd = getPara("password");
        String ConfirmPasswd = getPara("ConfirmPassword");

        String sql = "select * from user where username = ?";
        User user = User.dao.findFirst(sql, usrname);
        //根据用户输入的用户名去数据库查找，并将查找到的结果返回给user
        System.out.println(user);

        if (usrname.equals("")||passwd.equals("")){
            renderText("用户名或者密码不能为空");
            return;
        }
        if (!passwd.equals(ConfirmPasswd)) {
            renderText("两次密码不相同");
        }
        else {
            if (user != null) {
                renderText("用户名已存在");
            } else {
                User user1 = new User();//这句能不能删除
                user1.setUsername(usrname);
                user1.setPassword(passwd);
                user1.save();
                renderText("注册成功");
                renderTemplate("jump.html"); //声明渲染到jump.html
            }
        }
    }
}
