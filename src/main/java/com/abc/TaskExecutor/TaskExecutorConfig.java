package com.abc.TaskExecutor;
        /*
         *  author  :  ajing
         *  date    :  2018/4/10 9:26
         * */

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
@EnableAsync  //注解开启异步任务支持
public class TaskExecutorConfig implements AsyncConfigurer{
    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor taskExecutor=new ThreadPoolTaskExecutor();
        taskExecutor.setMaxPoolSize(100);//线程池维护线程的最大数量
        taskExecutor.setCorePoolSize(5);//线程池维护线程的最少数量
        taskExecutor.setQueueCapacity(25);//线程池所使用的缓冲队列
        taskExecutor.setKeepAliveSeconds(3000);//线程池维护线程所允许的空闲时间
        taskExecutor.initialize();
        return taskExecutor;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return null;
    }
}
