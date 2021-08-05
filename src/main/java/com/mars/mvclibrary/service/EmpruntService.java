package com.mars.mvclibrary.service;

import com.mars.mvclibrary.model.Emprunt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.function.ServerRequest;

import java.util.Arrays;
import java.util.List;

@Service
public class EmpruntService {

    @Autowired
    private RestTemplate restTemplate;


    public List<Emprunt> empruntEnCours(String token) {
        MultiValueMap<String, String> multiValueMap = new LinkedMultiValueMap<>();
        multiValueMap.add("Authorization", "Bearer " + token);
        HttpEntity<Void> httpEntity = new HttpEntity<>(multiValueMap);
        return Arrays.asList(restTemplate.exchange("http://localhost:8090/emprunt/utilisateur", HttpMethod.GET, httpEntity, Emprunt[].class).getBody());
    }

    public void prolonger(String token, int empruntId) {
        HttpHeaders headers = new HttpHeaders();
      headers.add(HttpHeaders.AUTHORIZATION, "Bearer " + token);
        Emprunt emprunt = new Emprunt();
        emprunt.setId(empruntId);
        HttpEntity<Emprunt> request = new HttpEntity<>(emprunt, headers );
        restTemplate.postForEntity("http://localhost:8090/emprunt/prolongation", request, Void.class);
    }
}
