package com.abc;
        /*
         *  author  :  ajing
         *  date    :  2018/4/10 11:18
         * */

import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class )
@ContextConfiguration(classes = TestConfig.class)  //加载ApplicationContext，加载测试配置类
@ActiveProfiles("dev")   //激活配置bean设定环境
public class Test {
    @Autowired
    private  TestBean testBean;
    @org.junit.Test
    public  void test(){
        String defineContent="from dev profile";
        Assert.assertEquals(defineContent,testBean.getContent());
    }

}
