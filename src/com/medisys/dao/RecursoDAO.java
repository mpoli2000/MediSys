package com.medisys.dao;

import com.medisys.entidades.Entidad;
import com.medisys.entidades.Recurso;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class RecursoDAO implements IEntidadDAO {
    private String DB_JDBC_DRIVER = "org.h2.Driver"; //driver base H2
    private String DB_URL = "jdbc:h2:~/MediSys";
    private String DB_USER = "mateo";
    private String DB_PASSWORD = "";

    public RecursoDAO(){
        System.out.println("Ejecucion del constructor RecursoDAO");
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
            preparedStatement = connection.prepareStatement("INSERT INTO Recursos VALUES (?,?,?,?,?,?,?,?)");
            preparedStatement.setInt(1, ((Recurso)entidad).getId_recurso());
            preparedStatement.setInt(2, ((Recurso)entidad).getDia());
            preparedStatement.setInt(3, ((Recurso)entidad).getId_consultorio());
            preparedStatement.setString(4, ((Recurso)entidad).getConsultorio());
            preparedStatement.setInt(5, ((Recurso)entidad).getId_medico());
            preparedStatement.setString(6, ((Recurso)entidad).getMedico());
            preparedStatement.setDate(7, Date.valueOf(((Recurso)entidad).getFecha_inicial()));
            preparedStatement.setDate(8, Date.valueOf(((Recurso)entidad).getFecha_final()));

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
            preparedStatement = connection.prepareStatement("UPDATE Recursos SET dia=?, id_consultorio=?," +
                    " consultorio=?, id_medico=?, medico=?, fecha_inicial=?, fecha_final=?" +
                    " WHERE id_recursos=?");

            preparedStatement.setInt(1, ((Recurso)entidad).getDia());
            preparedStatement.setInt(2, ((Recurso)entidad).getId_consultorio());
            preparedStatement.setString(3, ((Recurso)entidad).getConsultorio());
            preparedStatement.setInt(4, ((Recurso)entidad).getId_medico());
            preparedStatement.setString(5, ((Recurso)entidad).getMedico());
            preparedStatement.setDate(6,Date.valueOf(((Recurso)entidad).getFecha_inicial()));
            preparedStatement.setDate(7,Date.valueOf(((Recurso)entidad).getFecha_final()));
            preparedStatement.setInt(8, ((Recurso)entidad).getId_recurso());

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
    public void eliminar(int id_recursos) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            //1. levantar el driver y conectarnos
            Class.forName(DB_JDBC_DRIVER); // cargar driver base de datos
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            //2. preparar sentencia SQL
            preparedStatement = connection.prepareStatement("DELETE FROM Recursos WHERE id_recursos=?");
            preparedStatement.setInt(1,id_recursos);


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
    public Entidad buscar(int id_recursos) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Entidad entidad = null;

        try {
            //1. levantar el driver y conectarnos
            Class.forName(DB_JDBC_DRIVER); // cargar driver base de datos
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            //2. preparar sentencia SQL
            preparedStatement = connection.prepareStatement("SELECT * FROM Recursos WHERE id_recursos=?");
            preparedStatement.setInt(1,id_recursos);

            //3. ejecutar la sentencia
            ResultSet rs = preparedStatement.executeQuery();

            //evaluamos los resultados
            while (rs.next()){
                entidad = new Recurso();
                ((Recurso) entidad).setId_recurso(rs.getInt("id_recursos"));
                ((Recurso) entidad).setDia(rs.getInt("dia"));
                ((Recurso) entidad).setId_consultorio(rs.getInt("id_consultorio"));
                ((Recurso) entidad).setConsultorio(rs.getString("consultorio"));
                ((Recurso) entidad).setId_medico(rs.getInt("id_medico"));
                ((Recurso) entidad).setMedico(rs.getString("medico"));
                ((Recurso) entidad).setMedico(rs.getString("medico"));
                ((Recurso) entidad).setFecha_inicial(rs.getDate("fecha_inicial").toLocalDate());
                ((Recurso) entidad).setFecha_final(rs.getDate("fecha_final").toLocalDate());
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
            preparedStatement = connection.prepareStatement("SELECT * FROM Recursos");

            //3. ejecutar la sentencia
            ResultSet rs = preparedStatement.executeQuery();

            //evaluamos los resultados
            while (rs.next()){
                entidad = new Recurso();
                ((Recurso) entidad).setId_recurso(rs.getInt("id_recursos"));
                ((Recurso) entidad).setDia(rs.getInt("dia"));
                ((Recurso) entidad).setId_consultorio(rs.getInt("id_consultorio"));
                ((Recurso) entidad).setConsultorio(rs.getString("consultorio"));
                ((Recurso) entidad).setId_medico(rs.getInt("id_medico"));
                ((Recurso) entidad).setMedico(rs.getString("medico"));
                ((Recurso) entidad).setFecha_inicial(rs.getDate("fecha_inicial").toLocalDate());
                ((Recurso) entidad).setFecha_final(rs.getDate("fecha_final").toLocalDate());
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
