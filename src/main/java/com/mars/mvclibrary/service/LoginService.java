package com.mars.mvclibrary.service;

import com.mars.mvclibrary.model.Emprunt;
import com.mars.mvclibrary.model.LoginDto;
import com.mars.mvclibrary.model.OuvrageUtilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

@Service
public class LoginService {
    @Autowired
    private RestTemplate restTemplate;

    public String login(String login, String password) {
        return restTemplate.postForObject("http://localhost:8090/authenticate", new LoginDto (login, password), String.class );


    }
}
