package com.medisys.dao;

import com.medisys.entidades.Entidad;
import com.medisys.entidades.Paciente;

import java.util.ArrayList;      //cada una de las clases DAO implementa esta interfaz para usar polimorfismo
                                 //los metodos son los mismos, se comportan de diferente forma dependiendo
                                    //la clase del objeto que estoy instanciando

public interface IEntidadDAO {
    public void guardar(Entidad entidad) throws DAOException;
    public void modificar(Entidad entidad) throws DAOException;
    public void eliminar(int id) throws DAOException;
    public Entidad buscar(int id) throws DAOException;
    public ArrayList buscarTodos() throws DAOException;
}
