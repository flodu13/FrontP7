package com.mars.mvclibrary.service;

import com.mars.mvclibrary.model.Ouvrage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class OuvrageService {

    @Autowired
    private RestTemplate restTemplate;


    public List<Ouvrage> findAllOuvrage() {

        return Arrays.asList(restTemplate.getForObject("http://localhost:8090/ouvrage", Ouvrage[].class));
    }



}
