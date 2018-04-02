package com.abc.vo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/*
 *  author  :  ajing
 *  date    :  2018/3/30 16:22
 *  在实际项目中使用@value注入属性的时候工作量略大，
 *  因为每个项目要注入的变量的值太多了，
 *  这种时候我们可以使用基于类型安全的配置方式，
 *  就是将properties属性和一个Bean关联在一起，这样使用起来会更加方便
 *  同样适用将配置文件独立出一个子项目的情况，就像aprovider里要调用config里的配置文件也可以用这种方法调用成功
 * */
@Component
@ConfigurationProperties(prefix = "abc")
public class PropertiesBean {
    private String version;

    private String owner;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
