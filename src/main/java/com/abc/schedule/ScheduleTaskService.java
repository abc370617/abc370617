package com.abc.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/*
         *  author  :  ajing
         *  date    :  2018/4/10 10:22
         * */
@Service   //注意要在启动类里加@EnableScheduling注解
public class ScheduleTaskService {
    private static  final SimpleDateFormat dateFormat=new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 500)  //fixedDelay表示以任务结束为标志5秒执行一个任务，fixedRate表示以任务开始为标志5秒执行一个任务
    public  void reportCurrentTime(){
        System.out.println("每隔500毫秒执行一次"+dateFormat.format(new Date()));
    }
    @Scheduled(cron = "0 51 10 ? * *") //秒分钟小时天月星期，*/*第一个*表示起始量 第二个*表示增量
    public  void fixTimeExecute(){
        System.out.println("在指定时间执行："+dateFormat.format(new Date()));
    }
}
