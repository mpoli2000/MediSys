package com.medisys.entidades;

public class Consultorio implements Entidad{

    private int id_consultorio;
    private String nombre;

    public int getId_consultorio() {
        return id_consultorio;
    }

    public void setId_consultorio(int id_consultorio) {
        this.id_consultorio = id_consultorio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Consultorio{" +
                "id_consultorio=" + id_consultorio +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
