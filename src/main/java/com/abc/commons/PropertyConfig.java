package com.abc.commons;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

/*
 *  author  :  ajing
 *  date    :  2018/4/2 16:30
 * */
@Configuration
@ComponentScan("com.abc")
@PropertySource("classpath:test.properties")  //属性注入除了使用@Value注解还可以使用下面的Environment获取,但都必须导入配置文件地址
public class PropertyConfig {
//    @Value("${title}")
//    private  String title;
//
//    @Value("${name}")
//    private  String name;
//
    @Value("#{T(java.lang.Math).random()*100.0}")
    private double randNumber;   //这个使用environment不好使

    @Autowired
    private Environment environment;

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigure(){
        return new PropertySourcesPlaceholderConfigurer();
    }

    public void getResource(){
        System.out.println(environment.getProperty("title"));
        System.out.println(environment.getProperty("name"));
        System.out.println(environment.getProperty("randNumber"));
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(ResourceConfig.class);
        PropertyConfig propertyConfig = context.getBean(PropertyConfig.class);
        propertyConfig.getResource();
    }

}
