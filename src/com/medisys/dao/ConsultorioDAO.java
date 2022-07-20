package com.medisys.dao;

import com.medisys.entidades.Entidad;
import com.medisys.entidades.Consultorio;

import java.sql.*;
import java.util.ArrayList;

public class ConsultorioDAO implements IEntidadDAO{
    private String DB_JDBC_DRIVER = "org.h2.Driver"; //driver base H2
    private String DB_URL = "jdbc:h2:~/MediSys";
    private String DB_USER = "mateo";
    private String DB_PASSWORD = "";

    public ConsultorioDAO(){
        System.out.println("Ejecucion del constructor ConsultorioDAO");
    }

    @Override
    public void guardar(Entidad entidad) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            //1. levantar el driver y conectarnos
            Class.forName(DB_JDBC_DRIVER); // cargar driver base de datos
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            //2. preparar sentencia SQL
            preparedStatement = connection.prepareStatement("INSERT INTO Consultorios VALUES (?,?)");
            preparedStatement.setInt(1, ((Consultorio)entidad).getId_consultorio());
            preparedStatement.setString(2, ((Consultorio)entidad).getNombre());


            //3. ejecutar la sentencia
            int i = preparedStatement.executeUpdate();

            //4. evaluamos los resultados
            System.out.println("Registros insertados: " + i);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace(); // se imprime por consola
            throw new DAOException(e.getMessage()); //tiro exception hacia arriba
        } finally {
            try {
                preparedStatement.close();
            } catch (SQLException e2) {
                e2.printStackTrace();
                throw new DAOException(e2.getMessage());
            }
        }
    }


    @Override
    public void modificar(Entidad entidad) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            //1. levantar el driver y conectarnos
            Class.forName(DB_JDBC_DRIVER); // cargar driver base de datos
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            //2. preparar sentencia SQL
            preparedStatement = connection.prepareStatement("UPDATE Consultorios SET nombre=?"+
                    "WHERE id_consultorio=?");

            preparedStatement.setString(1, ((Consultorio)entidad).getNombre());
            preparedStatement.setInt(2, ((Consultorio)entidad).getId_consultorio());

            //3. ejecutar la sentencia
            int i = preparedStatement.executeUpdate();

            //4. evaluamos los resultados
            System.out.println("Registros modificados: " + i);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace(); // se imprime por consola
            throw new DAOException(e.getMessage()); //tiro exception hacia arriba
        } finally {
            try {
                preparedStatement.close();
            } catch (SQLException e2) {
                e2.printStackTrace();
                throw new DAOException(e2.getMessage());
            }
        }
    }

    @Override
    public void eliminar(int id_consultorio) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            //1. levantar el driver y conectarnos
            Class.forName(DB_JDBC_DRIVER); // cargar driver base de datos
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            //2. preparar sentencia SQL
            preparedStatement = connection.prepareStatement("DELETE FROM Consultorios WHERE id_consultorio=?");
            preparedStatement.setInt(1,id_consultorio);

            //3. ejecutar la sentencia
            int i = preparedStatement.executeUpdate();

            //4. evaluamos los resultados
            System.out.println("Registros borrados: " + i);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            throw new DAOException(e.getMessage());
        } finally {
            try {
                preparedStatement.close();
            } catch (SQLException e2) {
                e2.printStackTrace();
                throw new DAOException(e2.getMessage());
            }
        }
    }

    @Override
    public Entidad buscar(int id) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Entidad entidad = null;

        try {
            //1. levantar el driver y conectarnos
            Class.forName(DB_JDBC_DRIVER); // cargar driver base de datos
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            //2. preparar sentencia SQL
            preparedStatement = connection.prepareStatement("SELECT * FROM Consultorios WHERE id_consultorio=?");
            preparedStatement.setInt(1,id);

            //3. ejecutar la sentencia
            ResultSet rs = preparedStatement.executeQuery();

            //evaluamos los resultados
            while (rs.next()){
                entidad = new Consultorio();
                ((Consultorio) entidad).setId_consultorio(rs.getInt("id_consultorio"));
                ((Consultorio) entidad).setNombre(rs.getString("nombre"));
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            throw new DAOException(e.getMessage());
        } finally {
            try {
                preparedStatement.close();
            } catch (SQLException e2) {
                e2.printStackTrace();
                throw new DAOException(e2.getMessage());
            }
        }
        return entidad;
    }

    @Override
    public ArrayList buscarTodos() throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Entidad entidad = null;
        ArrayList entidades = new ArrayList();  //este metodo devuelve un ArrayList que contiene una colección de objetos Paciente

        try {
            //1. levantar el driver y conectarnos
            Class.forName(DB_JDBC_DRIVER); // cargar driver base de datos
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            //2. preparar sentencia SQL
            preparedStatement = connection.prepareStatement("SELECT * FROM Consultorios");

            //3. ejecutar la sentencia
            ResultSet rs = preparedStatement.executeQuery();

            //evaluamos los resultados
            while (rs.next()){
                entidad = new Consultorio();
                ((Consultorio) entidad).setId_consultorio(rs.getInt("id_consultorio"));
                ((Consultorio) entidad).setNombre(rs.getString("nombre"));
                entidades.add(entidad);
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            throw new DAOException(e.getMessage());
        } finally {
            try {
                preparedStatement.close();
            } catch (SQLException e2) {
                e2.printStackTrace();
                throw new DAOException(e2.getMessage());
            }
        }
        return entidades; //devuelve un ArrayList
    }
}
