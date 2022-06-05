package com.medisys;

public class Paciente extends Usuario{

    String nombreObraSocial;
    int nroAfiliado;

    public void reservarTurno() {

    }
    public void consultarTurno() {

    }
    public void mofdificarTurno() {

    }
    public void cancelarTurno() {

    }


    public Paciente() {
        //super.setNombre("Mateo");
        //super.setApellido("Policichio");
        //super.setDni(43243326);
        //super.setClave("medisys");
        //super.setEmail("mateopolicichio@gmail.com");
        this.nombreObraSocial = "Osde";
        this.nroAfiliado = 1234;

    }

    @Override
    public void crearUsuario() {

    }

    @Override
    public void modificar() {

    }

    @Override
    public void borrar() {

    }

    @Override
    public String toString() {
        return "Paciente{" +
                "nombreObraSocial='" + nombreObraSocial + '\'' +
                ", nroAfiliado=" + nroAfiliado +
                ", edad=" + edad +
                ", id=" + id +
                ", dni=" + dni +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", email='" + email + '\'' +
                ", clave='" + clave + '\'' +
                ", estado=" + estado +
                '}';
    }
}
