package com.medisys.entidades;

public class ObraSocial implements Entidad {

    private int id_obra_social;
    private String nombre;

    public int getId_obra_social() {
        return id_obra_social;
    }

    public void setId_obra_social(int id_obra_social) {
        this.id_obra_social = id_obra_social;
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
                "id_obra_social=" + id_obra_social +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
