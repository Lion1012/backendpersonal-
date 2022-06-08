package com.sistemas.informaticos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sistemas.informaticos.models.Traducido;
@Service
public class TraductorService {
    
    @Autowired
    RestTemplate restTemplate;

    public Traducido getTranslationFromAPI(String palabra){
        String url = "https://api.mymemory.translated.net/get?q="+palabra+"&langpair=es|en";
        Traducido traducido = restTemplate.getForObject(url, Traducido.class);
        return traducido;
    }
}
