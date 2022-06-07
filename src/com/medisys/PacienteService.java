package com.medisys;

import java.util.ArrayList;

public class PacienteService {
    private IPacienteDAO pacienteDAO;

    public PacienteService(){
        pacienteDAO = new PacienteDAOH2();     //instancio un pacienteDAOH2 en el constructor
    }

    public void guardarPaciente(Paciente paciente){
        pacienteDAO.guardar(paciente);
    }

    public void eliminarPaciente(int id_paciente){
        pacienteDAO.eliminar(id_paciente);
    }

    public Paciente buscarPaciente(int id_paciente){
        return pacienteDAO.buscar(id_paciente);
    }

    public ArrayList buscarTodos(){
        return pacienteDAO.buscarTodos();
    }

}
