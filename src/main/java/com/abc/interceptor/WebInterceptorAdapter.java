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
@EnableWebMvc
public class WebInterceptorAdapter implements WebMvcConfigurer {
    @Bean
    public  WebIntercrptor webIntercrptor(){
        return new WebIntercrptor();
    }
    //todo 访问不到jsp 报404
    //注入视图处理器bean
    @Bean
    public InternalResourceViewResolver viewResolver(){
        InternalResourceViewResolver resourceViewResolver=new InternalResourceViewResolver();
        resourceViewResolver.setPrefix("/WEB-INF/classes/templates/");//和实际目录是有区别的，因为运行时会编译到此目录
        resourceViewResolver.setSuffix(".jsp");
        resourceViewResolver.setViewClass(JstlView.class);
        return resourceViewResolver;
    }


    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/error").setViewName("404.html");
        registry.addViewController("/index").setViewName("index.html");
    }

    @Override    //添加拦截器
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(webIntercrptor()).addPathPatterns("/**");
    }


    //添加文件是暴露路径和文件的实际访问路径
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/view").addResourceLocations("/");
    }
    //参数路径带点不被忽略
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        configurer.setUseRegisteredSuffixPatternMatch(false);
    }
}
