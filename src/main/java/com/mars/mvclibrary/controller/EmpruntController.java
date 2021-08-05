package com.mars.mvclibrary.controller;


import com.mars.mvclibrary.service.EmpruntService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
public class EmpruntController {

    @Autowired
    EmpruntService empruntService;

    @GetMapping ("/empruntEnCours")
    public String empruntEnCours (Model model, HttpServletRequest request) {
        String token=null;

        if (request.getCookies()!=null) {
            for (Cookie cookie : request.getCookies()) {
                if (cookie.getName().equals("token")) {
                    token = cookie.getValue();
                }
            }
        }
model.addAttribute("emprunts",empruntService.empruntEnCours(token));
        model.addAttribute("isLogged", token!=null);
        return "EmpruntEnCours";
    }

    @PostMapping("/emprunt/renouveler")
    public String EmpruntEnCoursRenouveler (@RequestParam Integer empruntId,  Model model, HttpServletRequest request ) {
        String token=null;

        for(Cookie cookie : request.getCookies()) {
            if (cookie.getName().equals("token")) {
                token=cookie.getValue();
            }
        }
empruntService.prolonger(token, empruntId);

        return "redirect:/empruntEnCours";
    }
}
