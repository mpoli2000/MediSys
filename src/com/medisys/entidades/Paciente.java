package com.medisys.entidades;

public class Paciente implements Entidad{

    private int id_paciente;
    private String nombre;
    private String apellido;
    private String email;
    private String clave;
    private int id_obra_social;
    private String obra_social;

    public String getObra_social() {
        return obra_social;
    }

    public void setObra_social(String obra_social) {
        this.obra_social = obra_social;
    }

    public int getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(int id_paciente) {
        this.id_paciente = id_paciente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public int getId_obra_social() {
        return id_obra_social;
    }

    public void setId_obra_social(int id_obra_social) {
        this.id_obra_social = id_obra_social;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "id_paciente=" + id_paciente +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", email='" + email + '\'' +
                ", clave='" + clave + '\'' +
                ", id_obra_social=" + id_obra_social +
                ", obra_social='" + obra_social + '\'' +
                '}';
    }
}
