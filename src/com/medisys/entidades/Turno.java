package com.medisys.entidades;

import java.time.LocalDateTime;

public class Turno implements Entidad {
    private int id_turno;
    private LocalDateTime fecha_turno;
    private int id_consultorio;
    private String consultorio;
    private int id_medico;
    private String medico;
    private String os_medico;
    private int id_paciente;
    private String paciente;
    private String os_paciente;
    private int honorario;
    private float descuento;
    private float saldo;

    public int getId_turno() {
        return id_turno;
    }

    public void setId_turno(int id_turno) {
        this.id_turno = id_turno;
    }

    public LocalDateTime getFecha_turno() {
        return fecha_turno;
    }

    public void setFecha_turno(LocalDateTime fecha_turno) {
        this.fecha_turno = fecha_turno;
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

    public String getOs_medico() {
        return os_medico;
    }

    public void setOs_medico(String os_medico) {
        this.os_medico = os_medico;
    }

    public int getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(int id_paciente) {
        this.id_paciente = id_paciente;
    }

    public String getPaciente() {
        return paciente;
    }

    public void setPaciente(String paciente) {
        this.paciente = paciente;
    }

    public String getOs_paciente() {
        return os_paciente;
    }

    public void setOs_paciente(String os_paciente) {
        this.os_paciente = os_paciente;
    }

    public int getHonorario() {
        return honorario;
    }

    public void setHonorario(int honorario) {
        this.honorario = honorario;
    }

    public float getDescuento() {
        return descuento;
    }

    public void setDescuento(float descuento) {
        this.descuento = descuento;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Turno{" +
                "id_turno=" + id_turno +
                ", fecha_turno=" + fecha_turno +
                ", id_consultorio=" + id_consultorio +
                ", consultorio='" + consultorio + '\'' +
                ", id_medico=" + id_medico +
                ", medico='" + medico + '\'' +
                ", os_medico='" + os_medico + '\'' +
                ", id_paciente=" + id_paciente +
                ", paciente='" + paciente + '\'' +
                ", os_paciente='" + os_paciente + '\'' +
                ", honorarios=" + honorario +
                ", descuento=" + descuento +
                ", saldo=" + saldo +
                '}';
    }
}
