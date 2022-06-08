package com.sistemas.informaticos.controllers;

import com.sistemas.informaticos.models.Campeon;
import com.sistemas.informaticos.services.CampeonService;
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
        String listado = "Mascotas registradas:<br/>";
        for (Campeon campeon : campeones) {
            listado += campeon.getNombre() + "  ";
            listado += campeon.getLinea() + "  ";
            listado += "<br/>";
        }
        return listado;
    }
}
