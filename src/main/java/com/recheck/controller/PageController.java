package com.recheck.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class PageController {

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/main")
    public String toMainPage(){
        return "main";
    }

    @GetMapping("/error")
    public String toErrorPage(){
        return "error";
    }

    @GetMapping("/getError")
    public String toError(){
        return "getError";
    }


    /**
     * 案例，使用注解规定可以访问的用户角色
     * @return
     */
    @GetMapping("/a")
    @ResponseBody
    @PreAuthorize("hasAnyRole('ROLE_老师')")
    public String getA(){
        return "老师才可以访问";
    }
}
