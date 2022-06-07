package com.medisys;

public class Paciente{

    private int id_paciente;
    private String nombre;
    private String apellido;
    private String email;
    private String clave;
    private int dni;
    private String obra_social;
    private int nro_afiliado;
    private boolean estado;

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

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getObra_social() {
        return obra_social;
    }

    public void setObra_social(String obra_social) {
        this.obra_social = obra_social;
    }

    public int getNro_afiliado() {
        return nro_afiliado;
    }

    public void setNro_afiliado(int nro_afiliado) {
        this.nro_afiliado = nro_afiliado;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "id_paciente='" + id_paciente + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", email='" + email + '\'' +
                ", clave='" + clave + '\'' +
                ", dni=" + dni +
                ", obra_social='" + obra_social + '\'' +
                ", nro_afiliado=" + nro_afiliado +
                ", estado=" + estado +
                '}';
    }
}
