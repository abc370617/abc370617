package com.abc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/*
         *  author  :  ajing
         *  date    :  2018/4/10 11:16
         * */
@Configuration
public class TestConfig {
    @Bean
    @Profile("dev")  //设置bean的环境，可以使用@ActiveProfiles("dev")激活配置
    public TestBean devTestBean(){
        return new TestBean("from dev profile");
    }
    @Bean
    @Profile("pro")
    public TestBean proTestBean(){
        return new TestBean("from pro profile");
    }
}
