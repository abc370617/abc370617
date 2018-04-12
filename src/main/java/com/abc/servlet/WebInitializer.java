package com.abc.servlet;
        /*
         *  author  :  ajing
         *  date    :  2018/4/10 16:20
         * */

import com.abc.interceptor.WebInterceptorAdapter;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class WebInitializer implements WebApplicationInitializer { //提供servlet3.0接口，替代web.xml
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext context=new AnnotationConfigWebApplicationContext();
        context.register(WebInterceptorAdapter.class);//加载WebInterceptorAdapter是为了InternalResourceViewResolver配置
        context.setServletContext(servletContext); //注册配置类和当前servletContext关联
        ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(context));//注册DispatcherServlet
        servlet.addMapping("/");
        servlet.setLoadOnStartup(1);
        servlet.setAsyncSupported(true);//开启异步方法支持，适用于服务器推送技术
    }
}
