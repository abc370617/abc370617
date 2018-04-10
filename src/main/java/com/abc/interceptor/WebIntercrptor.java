package com.abc.interceptor;
        /*
         *  author  :  ajing
         *  date    :  2018/4/4 15:53
         * */

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 写完以后再webConfig里注入WebIntercrptor这个bean
 * 拦截器是对每次请求前后的业务做处理
 */

public class WebIntercrptor  extends HandlerInterceptorAdapter{
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        long startTime=System.currentTimeMillis();
        request.setAttribute("startTime",startTime);
        System.out.println("前拦截器处理完毕");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        long startTime = (long)  request.getAttribute("startTime");
        long endTime=System.currentTimeMillis();
        System.out.println("后拦截器处理完毕，本次处理时间为："+(endTime-startTime));
        request.setAttribute("handleTime",endTime-startTime);
    }
}
