package com.medisys.entidades;

public class Medico {
    private int id_medico;
    private String nombre;
    private String apellido;
    private String email;
    private String clave;
    private int dni;
    private int matricula;
    private String especialidad;
    private int id_obra_social;
    private String obra_social;
    private boolean estado;

    public int getId_medico() {
        return id_medico;
    }

    public void setId_medico(int id_medico) {
        this.id_medico = id_medico;
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

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public int getId_obra_social() {
        return id_obra_social;
    }

    public void setId_obra_social(int id_obra_social) {
        this.id_obra_social = id_obra_social;
    }

    public String getObra_social() {
        return obra_social;
    }

    public void setObra_social(String obra_social) {
        this.obra_social = obra_social;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Medico{" +
                "id_medico=" + id_medico +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", email='" + email + '\'' +
                ", clave='" + clave + '\'' +
                ", dni=" + dni +
                ", matricula=" + matricula +
                ", especialidad='" + especialidad + '\'' +
                ", id_obra_social=" + id_obra_social +
                ", obra_social='" + obra_social + '\'' +
                ", estado=" + estado +
                '}';
    }
}
