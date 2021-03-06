package com.abc.controller;

import com.abc.vo.PlanNote;
import com.abc.vo.PropertiesBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

        /*
 *  author  :  ajing
 *  date    :  2018/3/30 15:42
 * */

@Controller
@RequestMapping("planNote")

//@PropertySource("classpath:application.properties")
public class PlanNoteController {
    Logger logger=Logger.getLogger("PlanNoteController");

   // @Value(value="${abc.area}")  //application.properties文件里的属性获取通过@Value
   // private  String area;
    @Autowired
    private PropertiesBean propertiesBean;



    @RequestMapping(value = "getPlanNoteVersion", method = {RequestMethod.GET,RequestMethod.POST}, produces = "application/json;charset=utf-8")
    public PlanNote getPlanNoteVersion(){
        PlanNote planNote=new PlanNote();
       // planNote.setVersion(area);
        planNote.setOwner(propertiesBean.getOwner());
        logger.info("【获取笔记版本和开发者信息】");
        return planNote;
    }
    @RequestMapping("index")
    public String toIndex(){
        System.out.println("into index");
        return "index";
    }

    @RequestMapping("/advice")  //msg 取值是AdviceController里addAttributes方法里设定的
    public String getSomething(@ModelAttribute("msg")String msg,DemoObj obj){
        System.out.println("id:"+obj.getId()+" , name:"+obj.getName());
        throw new  IllegalArgumentException("非常抱歉参数有误 "+msg);
    }

}
