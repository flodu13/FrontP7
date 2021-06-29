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
    public String accueil ( Model model) {
        List<Ouvrage> ouvrages = ouvrageService.findAllOuvrage();

// logic to build student data
        model.addAttribute("ouvrages", ouvrages);
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

      return "accueil";
  }
}
