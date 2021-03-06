package com.sistemas.informaticos.controllers;

import com.sistemas.informaticos.models.Campeon;
import com.sistemas.informaticos.models.Traducido;
import com.sistemas.informaticos.services.CampeonService;
import com.sistemas.informaticos.services.TraductorService;
import com.sistemas.informaticos.utils.Utils;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Main {
    @Autowired
    CampeonService campeonService;

    @Autowired
    TraductorService traductorService;

    @GetMapping("/")
    public String inicio() {
        return "Mi servidor backend";
    }

    @GetMapping("/contar/{palabra}")
    public String cuentaletras(@PathVariable String palabra) {
        return Utils.cuentapalabra(palabra);
    }

    @GetMapping("/guarda")
    public String guardaCampeon(@RequestParam String nombre, @RequestParam String linea) {
        Campeon completo = new Campeon();
        completo.setNombre(nombre);
        completo.setLinea(linea);
        campeonService.guardCampeon(completo);
        return "Campeon creado correctamente.";

    }

    @GetMapping("/listar")
    public String listaCampeones() {
        ArrayList<Campeon> campeones = campeonService.listaCampeon();
        String listado = "Lista de campeones:<br/>";
        for (Campeon campeon : campeones) {
            listado += campeon.getNombre() + "  ";
            listado += campeon.getLinea() + "  ";
            listado += "<br/>";
        }
        return listado;
    }
    @GetMapping("/{palabra}")
    public String transforma(@PathVariable String palabra) {
        return Utils.transformame(palabra);
    }
    @GetMapping("/traduce/{palabra}")
    public String getTranslation(@PathVariable String palabra){
        Traducido traducido = traductorService.getTranslationFromAPI(palabra);
        return traducido.responseData.translatedText;
    }
}
