package com.mars.mvclibrary.controller;

import com.mars.mvclibrary.model.Ouvrage;
import com.mars.mvclibrary.service.OuvrageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class AccueilController {

    @Autowired
    OuvrageService ouvrageService;

    @GetMapping("/")
    public String accueil ( @RequestParam(required = false) String search, Model model, HttpServletRequest request) {

        List<Ouvrage> ouvrages;
        if (search==null)
        {
            ouvrages= ouvrageService.findAllOuvrage();
        } else {
            ouvrages=ouvrageService.findAllBySearch(search);
        }


// logic to build student data
        model.addAttribute("ouvrages", ouvrages);
        String token=null;

        if (request.getCookies()!=null) {
            for (Cookie cookie : request.getCookies()) {
                if (cookie.getName().equals("token")) {
                    token = cookie.getValue();
                }
            }
        }
        model.addAttribute("isLogged", token!=null);
        return "accueil";
    }
  @PostMapping("/emprunter")
    public String emprunter (@RequestParam Integer ouvrageId, Model model, HttpServletRequest request) {
       String token=null;

        for(Cookie cookie : request.getCookies()) {
            if (cookie.getName().equals("token")) {
                token=cookie.getValue();
            }
        }

ouvrageService.emprunter(1,ouvrageId, token);

      return "redirect:/";
  }


}
