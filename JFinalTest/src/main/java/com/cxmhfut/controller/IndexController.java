package com.cxmhfut.controller;

import com.cxmhfut.interceptor.AInterceptor;
import com.cxmhfut.interceptor.BInterceptor;
import com.cxmhfut.interceptor.ClassInterceptor;
import com.cxmhfut.interceptor.MethodInterceptor;
import com.cxmhfut.model.Blog;
import com.cxmhfut.service.ServiceImpl;
import com.jfinal.aop.Before;
import com.jfinal.aop.Clear;
import com.jfinal.aop.Duang;
import com.jfinal.core.Controller;
import com.jfinal.kit.Kv;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.SqlPara;

import java.util.List;

@Before(ClassInterceptor.class)
public class IndexController extends Controller {
    /**
     * action定义模板
     */
    @Clear
    public void index() {
        String msg = getPara("msg", "defaultMessage");
        //String values[] = getParaValues("test");//checkbox
        setAttr("msg", "Hello JFinal 3.0----->" + msg);
        getModel(Blog.class);
        renderTemplate("index.html");
    }

    public void add() {
        renderTemplate("add.html");
    }

    public void doAdd() {
        Blog blog = getModel(Blog.class);

        //用Record代替Model
        //Record record = new Record();
        //record.set("name", "blog_name");
        //record.set("desc", "blog_desc");
        //Db.save("t_blog",record);

        blog.save();
        renderText("提交成功");
    }

    public void sqlManagerFindAll() {
        String sql = Blog.dao.getSql("blogList");
        List<Blog> blogs = Blog.dao.find(sql);

        renderJson(blogs);
    }

    public void sqlManagerGetById() {
        String sql = Blog.dao.getSql("blogGetById");
        Blog blog = Blog.dao.findFirst(sql, 3);

        renderJson(blog);
    }

    public void sqlManagerGetBetween() {
        String sql = Blog.dao.getSql("blogBetween");
        List<Blog> blogs = Blog.dao.find(sql, 5, 7);

        renderJson(blogs);
    }

    public void sqlManagerGetBetweenNew(){
        Kv cond = Kv.by("a",5).set("b",7);
        SqlPara para = Blog.dao.getSqlPara("blog.blogBetweenNew",cond);

        List<Blog> blogs = Blog.dao.find(para);

        renderJson(blogs);
    }

    public void queryAllBlog() {
        //String sql = "select * from t_blog order by id desc";//不要在controller中写sql，此处仅为演示
        //List<Blog> blogs = Blog.dao.find(sql);
        //Blog blog1 = Blog.dao.findFirst(sql);

        Blog blog = Blog.dao.findById("3");
        System.out.println(blog.getStr("name"));
        System.out.println(blog.getStr("desc"));
        //分页查询数据记录
        Page<Blog> pageBlog = Blog.dao.paginate(1, 1, "select * ", "from t_blog order by id desc");
        renderJson(pageBlog);
    }

    public void update() {
        Blog blog = new Blog();
        blog.set("id", 3);
        blog.set("name", "name_3");
        blog.set("desc", "desc_3");
        blog.update();
        renderText("更新成功");
    }

    public void delete() {
        Blog.dao.deleteById(4);
    }

    /**
     * 测试 Method Interceptor 的用法
     */
    @Before(MethodInterceptor.class)
    public void testMethod() {
        renderTemplate("index.html");
    }

    public void testInjectMethod() {
        ServiceImpl service = Duang.duang(ServiceImpl.class);
        //ServiceImpl service = Duang.duang(ServiceImpl.class, InjectInterceptor.class);
        service.testInject();
        renderTemplate("index.html");
    }

    @Before({AInterceptor.class, BInterceptor.class})
    public void testInterceptorStack() {
        renderTemplate("index.html");
    }

    public void testTemplate(){
        renderTemplate("template-test.html");
    }
}
