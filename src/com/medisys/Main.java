package com.medisys;

import com.medisys.entidades.Paciente;
import com.medisys.service.PacienteService;
import com.medisys.service.ServiceException;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

    PacienteService pacienteService = new PacienteService();

    Paciente paciente = new Paciente();

    paciente.setId_paciente(10);
    paciente.setNombre("Gian");
    paciente.setApellido("Poli");
    paciente.setEmail("gian@gamil.com");
    paciente.setClave("");
    paciente.setDni(42334333);
    paciente.setObra_social("OSDE");
    paciente.setNro_afiliado(600003000);
    paciente.setEstado(true);

        //guardar paciente
        try {
            pacienteService.guardarPaciente(paciente);
            System.out.println(paciente);
        } catch (ServiceException e) {
            e.printStackTrace();
        }

        //buscar paciente id=10
        try {
            Paciente paciente2 = pacienteService.buscarPaciente(10);
            System.out.println(paciente2);
        } catch (ServiceException e) {
            e.printStackTrace();
        }

        //eliminar paciente id=10
        try {
            pacienteService.eliminarPaciente(10);
        } catch (ServiceException e) {
            e.printStackTrace();
        }

        System.out.println("Modificar Paciente:");//modificar paciente
        try {
            Paciente paciente4 = pacienteService.buscarPaciente(2);
            System.out.println(paciente4);
            paciente4.setEstado(true);
            pacienteService.modificarPaciente(paciente4);
            System.out.println(paciente4);
        } catch (ServiceException e) {
            e.printStackTrace();
        }

        System.out.println("Listar Pacientes:");//listar todos los pacientes
        ArrayList pacientes = null;
        try {
            pacientes = pacienteService.buscarTodos();
            for (Object objeto : pacientes) {
                Paciente paciente3 = (Paciente) objeto;
                System.out.println(paciente3);
            }
        } catch (ServiceException e) {
            e.printStackTrace();
        }


    }
}
