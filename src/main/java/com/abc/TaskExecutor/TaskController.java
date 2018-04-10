package com.abc.TaskExecutor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
         *  author  :  ajing
         *  date    :  2018/4/10 9:59
         * */
@RestController
@RequestMapping("task")
public class TaskController {
   @Autowired
    private  AsyncTaskService asyncTaskService;
   @RequestMapping("executeAsyncTask")
   public void executeAsyncTask(){
       for (int i = 0; i <100 ; i++) {
           asyncTaskService.executeAsyncTask(i);
           asyncTaskService.executeAsyncTaskPlus(i);
       }
   }

}
