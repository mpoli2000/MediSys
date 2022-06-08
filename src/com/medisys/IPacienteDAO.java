package com.medisys;

import java.util.ArrayList;

public interface IPacienteDAO {
    public void guardar(Paciente paciente) throws DAOException;
    public void modificar(Paciente paciente) throws DAOException;
    public void eliminar(int id_paciente) throws DAOException;
    public Paciente buscar(int id_paciente) throws DAOException;
    public ArrayList buscarTodos() throws DAOException;



}
