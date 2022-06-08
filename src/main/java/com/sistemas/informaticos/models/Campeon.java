package com.sistemas.informaticos.models;

import javax.persistence.Entity;

import javax.persistence.Table;

@Entity
@Table(name = "Campeon")
public class Campeon {

    String nombre;
    String linea;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLinea() {
        return linea;
    }

    public void setLinea(String linea) {
        this.linea = linea;
    }
}
