package com.mars.mvclibrary.controller;

import com.mars.mvclibrary.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    @GetMapping("/login")
    public String login (Model model) {
        model.addAttribute("isLogged", false);
        return "login";
    }

    @PostMapping("/login")
    public String login (@RequestParam String login, @RequestParam String password, Model model, HttpServletResponse response ) {

    String token= loginService.login(login, password);
    System.out.println(token);
        // create a cookie
        Cookie cookie = new Cookie("token", token);
        //add cookie to response
        response.addCookie(cookie);
        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout (HttpServletResponse response) {
        Cookie cookie = new Cookie("token", null);
        //Delate cookie to response
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        return "redirect:/";
    }

}
