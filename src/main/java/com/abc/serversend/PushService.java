package com.abc.serversend;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.async.DeferredResult;

/*
         *  author  :  ajing
         *  date    :  2018/4/12 18:07
         * */
@Service
public class PushService {

    private DeferredResult<String> deferredResult;
    public DeferredResult<String> getAsyncUpdate(){
        deferredResult=new DeferredResult<>();
        return deferredResult;
    };
    @Scheduled(fixedDelay = 5000)
    public void refresh(){
        if(deferredResult!=null){
            deferredResult.setResult(new Long(System.currentTimeMillis()).toString());
        }
    }

}
