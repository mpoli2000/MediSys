package com.medisys.entidades;

import java.time.LocalDate;
import java.time.LocalTime;

public class Turno {
    private int id_consultorio;
    private LocalDate fecha;
    private LocalTime hora;
    private int id_medico;
    private String os_medico;
    private int id_paciente;
    private String os_paciente;
    private int monto;
    private int descuento;
    private float saldo;

    public Turno(LocalDate fecha, LocalTime hora) {
        this.fecha = fecha;
        this.hora = hora;
    }

    public Turno() {
        this.fecha = LocalDate.now();
    }

    public int getId_consultorio() {
        return id_consultorio;
    }

    public void setId_consultorio(int id_consultorio) {
        this.id_consultorio = id_consultorio;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public int getId_medico() {
        return id_medico;
    }

    public void setId_medico(int id_medico) {
        this.id_medico = id_medico;
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

    public String getOs_paciente() {
        return os_paciente;
    }

    public void setOs_paciente(String os_paciente) {
        this.os_paciente = os_paciente;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public int getDescuento() {
        return descuento;
    }

    public void setDescuento(int descuento) {
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
        return "Turnos{" +
                "id_consultorio=" + id_consultorio +
                ", fecha=" + fecha +
                ", hora=" + hora +
                ", id_medico=" + id_medico +
                ", os_medico='" + os_medico + '\'' +
                ", id_paciente=" + id_paciente +
                ", os_paciente='" + os_paciente + '\'' +
                ", monto=" + monto +
                ", descuento=" + descuento +
                ", saldo=" + saldo +
                '}';
    }
}
