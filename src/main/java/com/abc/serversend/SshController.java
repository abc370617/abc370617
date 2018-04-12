package com.abc.serversend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

/*
         *  author  :  ajing
         *  date    :  2018/4/12 17:57
         * */
@Controller
public class SshController {
    @RequestMapping(value = "send",produces = "test/event-stream")
    @ResponseBody
    public String push(){
        Random r =new Random();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "数据："+r.nextInt();
    }


}
