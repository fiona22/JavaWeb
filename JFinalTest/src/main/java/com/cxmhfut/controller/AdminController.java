package com.cxmhfut.controller;

import com.jfinal.core.Controller;

public class AdminController extends Controller {
    public void index(){
        setAttr("msg", "Hello JFinal 3.0");
        renderTemplate("index.html");
    }
}
