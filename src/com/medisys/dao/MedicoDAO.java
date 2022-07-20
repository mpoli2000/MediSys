package com.medisys.dao;

import com.medisys.entidades.Entidad;
import com.medisys.entidades.Medico;


import java.sql.*;
import java.util.ArrayList;

public class MedicoDAO implements IEntidadDAO{

    private String DB_JDBC_DRIVER = "org.h2.Driver"; //driver base H2
    private String DB_URL = "jdbc:h2:~/MediSys";
    private String DB_USER = "mateo";
    private String DB_PASSWORD = "";

    public MedicoDAO(){
        System.out.println("Ejecucion del constructor MedicoDAO");
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
            preparedStatement = connection.prepareStatement("INSERT INTO Medicos VALUES (?,?,?,?,?,?,?)");
            preparedStatement.setInt(1, ((Medico)entidad).getId_medico());
            preparedStatement.setString(2, ((Medico)entidad).getNombre());
            preparedStatement.setString(3, ((Medico)entidad).getApellido());
            preparedStatement.setString(4,((Medico)entidad).getEmail());
            preparedStatement.setString(5, ((Medico)entidad).getClave());
            preparedStatement.setInt(6, ((Medico)entidad).getId_obra_social());
            preparedStatement.setString(7, ((Medico)entidad).getObra_social());

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
            preparedStatement = connection.prepareStatement("UPDATE Medicos SET nombre=?, apellido=?," +
                    " email=?, clave=?, id_obra_social=?, obra_social=?" +
                    " WHERE id_medico=?");

            preparedStatement.setString(1, ((Medico)entidad).getNombre());
            preparedStatement.setString(2, ((Medico)entidad).getApellido());
            preparedStatement.setString(3, ((Medico)entidad).getEmail());
            preparedStatement.setString(4, ((Medico)entidad).getClave());
            preparedStatement.setInt(5, ((Medico)entidad).getId_obra_social());
            preparedStatement.setString(6, ((Medico)entidad).getObra_social());
            preparedStatement.setInt(7, ((Medico)entidad).getId_medico());

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
    public void eliminar(int id_medico) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            //1. levantar el driver y conectarnos
            Class.forName(DB_JDBC_DRIVER); // cargar driver base de datos
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            //2. preparar sentencia SQL
            preparedStatement = connection.prepareStatement("DELETE FROM Medicos WHERE id_medico=?");
            preparedStatement.setInt(1,id_medico);

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
            preparedStatement = connection.prepareStatement("SELECT * FROM Medicos WHERE id_medico=?");
            preparedStatement.setInt(1,id);

            //3. ejecutar la sentencia
            ResultSet rs = preparedStatement.executeQuery();

            //evaluamos los resultados
            while (rs.next()){
                entidad = new Medico();
                ((Medico) entidad).setId_medico(rs.getInt("id_medico"));
                ((Medico) entidad).setNombre(rs.getString("nombre"));
                ((Medico) entidad).setApellido(rs.getString("apellido"));
                ((Medico) entidad).setEmail(rs.getString("email"));
                ((Medico) entidad).setClave(rs.getString("clave"));
                ((Medico) entidad).setId_obra_social(rs.getInt("id_obra_social"));
                ((Medico) entidad).setObra_social(rs.getString("obra_social"));
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
            preparedStatement = connection.prepareStatement("SELECT * FROM Medicos");

            //3. ejecutar la sentencia
            ResultSet rs = preparedStatement.executeQuery();

            //evaluamos los resultados
            while (rs.next()){
                entidad = new Medico();
                ((Medico) entidad).setId_medico(rs.getInt("id_medico"));
                ((Medico) entidad).setNombre(rs.getString("nombre"));
                ((Medico) entidad).setApellido(rs.getString("apellido"));
                ((Medico) entidad).setEmail(rs.getString("email"));
                ((Medico) entidad).setClave(rs.getString("clave"));
                ((Medico) entidad).setId_obra_social(rs.getInt("id_obra_social"));
                ((Medico) entidad).setObra_social(rs.getString("obra_social"));
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
