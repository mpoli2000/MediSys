package com.medisys;

abstract class Usuario {

    int edad;
    int id;
    int dni;
    String nombre;
    String apellido;
    String email;
    String clave;
    boolean estado;

    public abstract void crearUsuario();
    public abstract void modificar();
    public abstract void borrar();

    public Usuario() {
        this.setNombre("Mateo");
        this.setApellido("Policichio");
        this.setDni(43243326);
        this.setClave("medisys");
        this.setEmail("mateopolicichio@gmail.com");
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
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

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "edad=" + edad +
                ", id=" + id +
                ", dni=" + dni +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", email='" + email + '\'' +
                ", clave='" + clave + '\'' +
                ", estado=" + estado +
                '}';
    }

    public void nombre(String mateo) {
    }
}


