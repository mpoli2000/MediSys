package com.medisys.service;
import com.medisys.dao.DAOException;
import com.medisys.dao.IPacienteDAO;
import com.medisys.dao.PacienteDAOH2;
import com.medisys.entidades.Paciente;
import com.medisys.service.ServiceException;

import java.util.ArrayList;

public class PacienteService {
    private IPacienteDAO pacienteDAO;

    public PacienteService(){
        pacienteDAO = new PacienteDAOH2();     //instancio un pacienteDAOH2 en el constructor
    }

    public void guardarPaciente(Paciente paciente) throws ServiceException {
        try {
            pacienteDAO.guardar(paciente);
        } catch (DAOException e) {
            e.printStackTrace();
            throw new ServiceException(e.getMessage());
        }
    }

    public void modificarPaciente(Paciente paciente) throws ServiceException {
        try {
            pacienteDAO.modificar(paciente);
        } catch (DAOException e) {
            e.printStackTrace();
            throw new ServiceException(e.getMessage());
        }
    }

    public void eliminarPaciente(int id_paciente) throws ServiceException {
        try {
            pacienteDAO.eliminar(id_paciente);
        } catch (DAOException e) {
            e.printStackTrace();
            throw new ServiceException(e.getMessage());
        }
    }

    public Paciente buscarPaciente(int id_paciente) throws ServiceException {
        try {
            return pacienteDAO.buscar(id_paciente);
        } catch (DAOException e) {
            e.printStackTrace();
            throw new ServiceException(e.getMessage());
        }
    }

    public ArrayList buscarTodos() throws ServiceException {
        try {
            return pacienteDAO.buscarTodos();
        } catch (DAOException e) {
            e.printStackTrace();
            throw new ServiceException(e.getMessage());
        }
    }

}
