package com.demo.web.controller;

import java.util.Map;

import com.demo.web.service.PersonService;
import com.hubwiz.web.RequestMethod;
import com.hubwiz.web.annotation.Autowired;
import com.hubwiz.web.annotation.Controller;
import com.hubwiz.web.annotation.RequestMapping;
import com.hubwiz.web.bean.ModelAndView;
import com.hubwiz.web.bean.Param;

@Controller
public class HomeController {

    @Autowired
    private PersonService ps;

    //主界面
    @RequestMapping(path = "/home", method = RequestMethod.GET)
    public ModelAndView home() {
        return new ModelAndView("home.jsp").addmData("message", "Welcome Hubwiz.com");
    }

    //获取person信息
    @RequestMapping(path = "/persons", method = RequestMethod.GET)
    public ModelAndView getPersons() {
        if (ps == null) {
            System.out.println("++++++++++++");
            return new ModelAndView("home.jsp").addmData("message", "Welcome Hubwiz.com");
        }
        return new ModelAndView("persons.jsp").addmData("persons", ps.getPersons());
    }

    //处理用户登录
    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public ModelAndView login(Param param) {
        Map<String, Object> user = param.getFieldMap();
        System.out.println(user.get("username"));
        System.out.println(user.get("password"));
        return new ModelAndView("home.jsp").addmData("message", "Welcome Hubwiz.com");
    }
}
