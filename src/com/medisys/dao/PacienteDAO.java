package com.medisys.dao;

import com.medisys.entidades.Entidad;
import com.medisys.entidades.Paciente;

import java.sql.*;
import java.util.ArrayList;

public class PacienteDAO implements IEntidadDAO {

    private String DB_JDBC_DRIVER = "org.h2.Driver"; //driver base H2
    private String DB_URL = "jdbc:h2:~/MediSys";
    private String DB_USER = "mateo";
    private String DB_PASSWORD = "";

    public PacienteDAO(){
        System.out.println("Ejecucion del constructor PacienteDAO");
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
            preparedStatement = connection.prepareStatement("INSERT INTO Pacientes VALUES (?,?,?,?,?,?,?)");
            preparedStatement.setInt(1, ((Paciente)entidad).getId_paciente());
            preparedStatement.setString(2, ((Paciente)entidad).getNombre());
            preparedStatement.setString(3, ((Paciente)entidad).getApellido());
            preparedStatement.setString(4,((Paciente)entidad).getEmail());
            preparedStatement.setString(5, ((Paciente)entidad).getClave());
            preparedStatement.setInt(6, ((Paciente)entidad).getId_obra_social());
            preparedStatement.setString(7, ((Paciente)entidad).getObra_social());


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
            preparedStatement = connection.prepareStatement("UPDATE Pacientes SET nombre=?, apellido=?," +
                    " email=?, clave=?, id_obra_social=?, obra_social=?" +
                    " WHERE id_paciente=?");

            preparedStatement.setString(1, ((Paciente)entidad).getNombre());
            preparedStatement.setString(2, ((Paciente)entidad).getApellido());
            preparedStatement.setString(3, ((Paciente)entidad).getEmail());
            preparedStatement.setString(4, ((Paciente)entidad).getClave());
            preparedStatement.setInt(5, ((Paciente)entidad).getId_obra_social());
            preparedStatement.setString(6, ((Paciente)entidad).getObra_social());
            preparedStatement.setInt(7, ((Paciente)entidad).getId_paciente());

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
    public void eliminar(int id_paciente) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            //1. levantar el driver y conectarnos
            Class.forName(DB_JDBC_DRIVER); // cargar driver base de datos
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            //2. preparar sentencia SQL
            preparedStatement = connection.prepareStatement("DELETE FROM Pacientes WHERE id_paciente=?");
            preparedStatement.setInt(1,id_paciente);

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
            preparedStatement = connection.prepareStatement("SELECT * FROM Pacientes WHERE id_paciente=?");
            preparedStatement.setInt(1,id);

            //3. ejecutar la sentencia
            ResultSet rs = preparedStatement.executeQuery();

            //evaluamos los resultados
            while (rs.next()){
                entidad = new Paciente();
                ((Paciente) entidad).setId_paciente(rs.getInt("id_paciente"));
                ((Paciente) entidad).setNombre(rs.getString("nombre"));
                ((Paciente) entidad).setApellido(rs.getString("apellido"));
                ((Paciente) entidad).setEmail(rs.getString("email"));
                ((Paciente) entidad).setClave(rs.getString("clave"));
                ((Paciente) entidad).setId_obra_social(rs.getInt("id_obra_social"));
                ((Paciente) entidad).setObra_social(rs.getString("obra_social"));
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
            preparedStatement = connection.prepareStatement("SELECT * FROM Pacientes");

            //3. ejecutar la sentencia
            ResultSet rs = preparedStatement.executeQuery();

            //evaluamos los resultados
            while (rs.next()){
                entidad = new Paciente();
                ((Paciente) entidad).setId_paciente(rs.getInt("id_paciente"));
                ((Paciente) entidad).setNombre(rs.getString("nombre"));
                ((Paciente) entidad).setApellido(rs.getString("apellido"));
                ((Paciente) entidad).setEmail(rs.getString("email"));
                ((Paciente) entidad).setClave(rs.getString("clave"));
                ((Paciente) entidad).setId_obra_social(rs.getInt("id_obra_social"));
                ((Paciente) entidad).setObra_social(rs.getString("obra_social"));
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
