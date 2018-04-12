package com.abc.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

/*
         *  author  :  ajing
         *  date    :  2018/4/12 16:22
         * */
@ControllerAdvice
public class AdviceController {
    @ExceptionHandler(value = Exception.class)  //全局处理异常
    public ModelAndView exception(Exception exception, WebRequest request){
        ModelAndView modelAndView=new ModelAndView("404");
        modelAndView.addObject("errorMessage",exception.getMessage());
        return modelAndView;
    }

    @ModelAttribute  //将键值对添加到全局
    public  void addAttributes(Model model){
        model.addAttribute("msg","额外信息");
    }

    @InitBinder   //自动绑定前台请求参数到Model中
    public  void initBinder(WebDataBinder webDataBinder){
        webDataBinder.setDisallowedFields("id");  //过滤掉id参数
    }
}
