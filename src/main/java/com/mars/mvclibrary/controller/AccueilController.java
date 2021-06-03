package com.mars.mvclibrary.controller;

import com.mars.mvclibrary.model.Ouvrage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AccueilController {

    @GetMapping("/")
    public String accueil ( Model model) {
        model.addAttribute("ouvrages", null);
        List<Ouvrage> ouvrages = new ArrayList<Ouvrage>();
// logic to build student data
        model.addAttribute("ouvrages", ouvrages);
        return "accueil";
    }

}
