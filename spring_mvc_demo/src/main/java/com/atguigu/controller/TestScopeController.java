package com.atguigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class TestScopeController {

    @RequestMapping("/test/mav")
    public ModelAndView testMAV(){
        /*
            ModelAndView包含Model 和 View 的功能
                Model:向请求域共享数据
                View:设置逻辑视图实现页面跳转
         */
        ModelAndView mav=new ModelAndView();
        mav.addObject("testRequest","hello,ModelAndView");

        mav.setViewName("success");
        return mav;
    }

    @RequestMapping("/test/model")
    public String testModel(Model model){
        model.addAttribute("testModel","hello,Model");
        return "success";
    }

    @RequestMapping("/test/modelMap")
    public String testModelMap(ModelMap modelMap){
        modelMap.addAttribute("testModelMap","hello,ModelMap");
        return "success";
    }

    @RequestMapping("/test/map")
    public String testMap(Map<String,Object> map){
        map.put("testMap","hello,Map");
        return "success";
    }

    @RequestMapping("/test/session")
    public String testSession(HttpSession Session){
        Session.setAttribute("testSession","hello,Session");
        return "success";
    }

    @RequestMapping("/test/application")
    public String testApplication(HttpSession Session){
        ServletContext servletContext = Session.getServletContext();
        servletContext.setAttribute("testApplication","hello,Application");
        return "success";
    }
}
