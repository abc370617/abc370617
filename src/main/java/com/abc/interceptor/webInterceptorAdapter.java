package com.abc.interceptor;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/*
 *  author  :  ajing
 *  date    :  2018/4/9 14:55
 * */
@Configuration
public class webInterceptorAdapter implements WebMvcConfigurer {
    @Bean
    public  WebIntercrptor webIntercrptor(){
        return new WebIntercrptor();
    }
    //注入视图处理器bean
    @Bean
    public InternalResourceViewResolver viewResolver(){
        InternalResourceViewResolver resourceViewResolver=new InternalResourceViewResolver();
        resourceViewResolver.setPrefix("/templates/");
        resourceViewResolver.setSuffix(".html");
        resourceViewResolver.setViewClass(JstlView.class);
        return resourceViewResolver;
    }


    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/error").setViewName("404.html");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(webIntercrptor()).addPathPatterns("/**");
    }


    //添加文件是暴露路径和文件的实际访问路径
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/view").addResourceLocations("/");
    }
}
