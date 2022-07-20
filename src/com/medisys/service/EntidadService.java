package com.medisys.service;

import com.medisys.dao.*;
import com.medisys.entidades.*;

import java.util.ArrayList;

public class EntidadService {

    private IEntidadDAO entidadDAO;// se implementa una unica EntidadService y se instancian los objetos en el constructor
                                    // dependiendo de la clase
    private Entidad entidad;

    public EntidadService(Entidad entidad){ //constructor
        System.out.println("Ejecucion de Constructor EntidadService");
        if(entidad instanceof Paciente) entidadDAO = new PacienteDAO();
        if(entidad instanceof Medico) entidadDAO = new MedicoDAO();
        if(entidad instanceof ObraSocial) entidadDAO = new ObraSocialDAO();
        if(entidad instanceof Consultorio) entidadDAO = new ConsultorioDAO();
        if(entidad instanceof Recurso) entidadDAO = new RecursoDAO();
        if(entidad instanceof Turno) entidadDAO = new TurnoDAO();

        this.entidad = entidad;

    }

    public void guardar() throws ServiceException {
        try {
            entidadDAO.guardar(entidad);
        } catch (DAOException e) {
            e.printStackTrace();
            throw new ServiceException(e.getMessage());
        }
    }

    public void modificar() throws ServiceException {
        try {
            entidadDAO.modificar(entidad);
        } catch (DAOException e) {
            e.printStackTrace();
            throw new ServiceException(e.getMessage());
        }
    }

    public void eliminar(int id) throws ServiceException {
        try {
            entidadDAO.eliminar(id);
        } catch (DAOException e) {
            e.printStackTrace();
            throw new ServiceException(e.getMessage());
        }
    }

    public Entidad buscar(int id) throws ServiceException {
        try {
            return entidadDAO.buscar(id);
        } catch (DAOException e) {
            e.printStackTrace();
            throw new ServiceException(e.getMessage());
        }
    }

    public ArrayList buscarTodos() throws ServiceException {
        try {
            return entidadDAO.buscarTodos();
        } catch (DAOException e) {
            e.printStackTrace();
            throw new ServiceException(e.getMessage());
        }
    }

}
