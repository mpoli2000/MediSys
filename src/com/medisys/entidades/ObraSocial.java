package com.medisys.entidades;

public class ObraSocial {

    private int obra_social;
    private String nombre;

    public int getObra_social() {
        return obra_social;
    }

    public void setObra_social(int obra_social) {
        this.obra_social = obra_social;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "ObraSocial{" +
                "obra_social=" + obra_social +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
