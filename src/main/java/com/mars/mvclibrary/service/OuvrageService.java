package com.mars.mvclibrary.service;

import com.mars.mvclibrary.model.Emprunt;
import com.mars.mvclibrary.model.Ouvrage;
import com.mars.mvclibrary.model.OuvrageUtilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
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

// supprimer utilisateurId, > utiliser le back utilisateur connectée
    public Emprunt emprunter(int utilisateurId, int ouvrageId, String token) {
        MultiValueMap <String, String>  multiValueMap = new LinkedMultiValueMap<>();
        multiValueMap.add("Authorization", "Bearer "+token);
        HttpEntity<OuvrageUtilisateur> httpEntity = new HttpEntity<>(new OuvrageUtilisateur (utilisateurId, ouvrageId), multiValueMap);
        return restTemplate.exchange("http://localhost:8090/emprunt", HttpMethod.POST, httpEntity, Emprunt.class).getBody();
    }

    public List<Ouvrage> findAllBySearch(String search) {
        return Arrays.asList(restTemplate.getForObject("http://localhost:8090/ouvrage?search=" + search, Ouvrage[].class));
    }
}
