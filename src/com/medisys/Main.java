package com.medisys;

public class Main {
    public static void main(String[] args) {

    PacienteService pacienteService = new PacienteService();

    Paciente paciente = new Paciente();

    paciente.setId_paciente(3);
    paciente.setNombre("Gian");
    paciente.setApellido("Poli");
    paciente.setEmail("gian@gamil.com");
    paciente.setClave("");
    paciente.setDni(42334333);
    paciente.setObra_social("OSDE");
    paciente.setNro_afiliado(600003000);
    paciente.setEstado(true);

    pacienteService.guardarPaciente(paciente);

    }
}
