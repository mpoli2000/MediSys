package com.medisys.entidades;

import java.sql.Date;
import java.time.LocalDate;

public class Recurso implements Entidad {
    private int id_recurso;
    private int dia;
    private int id_consultorio;
    private String consultorio;
    private int id_medico;
    private String medico;
    private LocalDate fecha_inicial;
    private LocalDate fecha_final;

    public int getId_recurso() {
        return id_recurso;
    }

    public void setId_recurso(int id_recurso) {
        this.id_recurso = id_recurso;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getId_consultorio() {
        return id_consultorio;
    }

    public void setId_consultorio(int id_consultorio) {
        this.id_consultorio = id_consultorio;
    }

    public String getConsultorio() {
        return consultorio;
    }

    public void setConsultorio(String consultorio) {
        this.consultorio = consultorio;
    }

    public int getId_medico() {
        return id_medico;
    }

    public void setId_medico(int id_medico) {
        this.id_medico = id_medico;
    }

    public String getMedico() {
        return medico;
    }

    public void setMedico(String medico) {
        this.medico = medico;
    }

    public LocalDate getFecha_inicial() {
        return fecha_inicial;
    }

    public void setFecha_inicial(LocalDate fecha_inicial) {
        this.fecha_inicial = fecha_inicial;
    }

    public LocalDate getFecha_final() {
        return fecha_final;
    }

    public void setFecha_final(LocalDate fecha_final) {
        this.fecha_final = fecha_final;
    }

    @Override
    public String toString() {
        return "Recurso{" +
                "id_recurso=" + id_recurso +
                ", dia=" + dia +
                ", id_consultorio=" + id_consultorio +
                ", consultorio='" + consultorio + '\'' +
                ", id_medico=" + id_medico +
                ", medico='" + medico + '\'' +
                ", fecha_inicial=" + fecha_inicial +
                ", fecha_final=" + fecha_final +
                '}';
    }
}
