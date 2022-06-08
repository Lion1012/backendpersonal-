package com.sistemas.informaticos.services;

import com.sistemas.informaticos.models.Campeon;
import com.sistemas.informaticos.repositories.CampeonRepository;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CampeonService {
    @Autowired
    CampeonRepository campeonRepository;

    public Campeon guardCampeon(Campeon campeon) {
        return campeonRepository.save(campeon);
    }
    public ArrayList<Campeon> listaCampeon(){
        ArrayList<Campeon> campeones = (ArrayList<Campeon>) campeonRepository.findAll();
        return campeones;
    }
}
