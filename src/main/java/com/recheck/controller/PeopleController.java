package com.recheck.controller;

import com.recheck.entity.People;
import com.recheck.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class PeopleController {


    @Autowired
    public PeopleService peopleService;

    @PostMapping("/addPeople")
    public String addPeople(Model model , People people){
        System.out.println(people);
        peopleService.addPeople(people);
        model.addAttribute("msg","注册成功,可以登录了");
        return "login";
    }

}
