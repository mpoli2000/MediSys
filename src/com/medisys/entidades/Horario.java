package com.medisys.entidades;

import java.time.LocalTime;

public class Horario {
    private int id_horarios;
    private int id_consultorio;
    private String nombre;
    private String dia;
    private LocalTime hora_inicial;
    private LocalTime hora_final;
    private int id_medico;
    private boolean estado;



    public int getId_horarios() {
        return id_horarios;
    }

    public void setId_horarios(int id_horarios) {
        this.id_horarios = id_horarios;
    }

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

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public LocalTime getHora_inicial() {
        return hora_inicial;
    }

    public void setHora_inicial(LocalTime hora_inicial) {
        this.hora_inicial = hora_inicial;
    }

    public LocalTime getHora_final() {
        return hora_final;
    }

    public void setHora_final(LocalTime hora_final) {
        this.hora_final = hora_final;
    }

    public int getId_medico() {
        return id_medico;
    }

    public void setId_medico(int id_medico) {
        this.id_medico = id_medico;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Horario{" +
                "id_horarios=" + id_horarios +
                ", id_consultorio=" + id_consultorio +
                ", nombre='" + nombre + '\'' +
                ", dia='" + dia + '\'' +
                ", hora_inicial=" + hora_inicial +
                ", hora_final=" + hora_final +
                ", id_medico=" + id_medico +
                ", estado=" + estado +
                '}';
    }
}
