package com.abc.TaskExecutor;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/*
         *  author  :  ajing
         *  date    :  2018/4/10 9:55
         * */
@Service
public class AsyncTaskService {
    @Async //表明该方法是个异步方法，如果注解再类级别则表明该类所有方法都是异步方法
    public void executeAsyncTask(Integer i){
        System.out.println("执行异步任务："+i);
    }
    @Async
    public void executeAsyncTaskPlus(Integer i){
        System.out.println("执行异步任务plus："+i);
    }



}
