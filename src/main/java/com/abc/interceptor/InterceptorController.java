package com.abc.interceptor;
        /*
         *  author  :  ajing
         *  date    :  2018/4/10 10:13
         * */

import com.abc.vo.PlanNote;
import com.abc.vo.PropertiesBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
@RequestMapping("interceptor")
public class InterceptorController {

    Logger logger=Logger.getLogger("InterceptorController");
    @Autowired
    private PropertiesBean propertiesBean;

    @RequestMapping(value = "404", method = {RequestMethod.GET,RequestMethod.POST}, produces = "application/json;charset=utf-8")
    public String into404(){
        PlanNote planNote=new PlanNote();
        planNote.setOwner(propertiesBean.getOwner());
        logger.info("【获取笔记版本和开发者信息】");
        return "404";
    }
}
