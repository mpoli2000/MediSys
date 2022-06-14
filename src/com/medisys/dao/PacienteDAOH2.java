package com.medisys.dao;
import com.medisys.dao.DAOException;
import com.medisys.dao.IPacienteDAO;
import com.medisys.entidades.Paciente;

import java.sql.*;
import java.util.ArrayList;

public class PacienteDAOH2 implements IPacienteDAO {

    private String DB_JDBC_DRIVER = "org.h2.Driver"; //driver base H2
    private String DB_URL = "jdbc:h2:~/MediSys";
    private String DB_USER = "mateo";
    private String DB_PASSWORD = "";


    @Override
    public void guardar(Paciente paciente) throws DAOException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            //1. levantar el driver y conectarnos
            Class.forName(DB_JDBC_DRIVER); // cargar driver base de datos
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            //2. preparar sentencia SQL
            preparedStatement = connection.prepareStatement("INSERT INTO Pacientes VALUES (?,?,?,?,?,?,?,?,?,?)");
            preparedStatement.setInt(1, paciente.getId_paciente());
            preparedStatement.setString(2, paciente.getNombre());
            preparedStatement.setString(3, paciente.getApellido());
            preparedStatement.setString(4,paciente.getEmail());
            preparedStatement.setString(5, paciente.getClave());
            preparedStatement.setInt(6, paciente.getDni());
            preparedStatement.setInt(7, paciente.getId_obra_social());
            preparedStatement.setString(8, paciente.getObra_social());
            preparedStatement.setInt(9,paciente.getNro_afiliado());
            preparedStatement.setBoolean(10,paciente.isEstado());

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
    public void modificar(Paciente paciente) throws DAOException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            //1. levantar el driver y conectarnos
            Class.forName(DB_JDBC_DRIVER); // cargar driver base de datos
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            //2. preparar sentencia SQL
            preparedStatement = connection.prepareStatement("UPDATE Pacientes SET nombre=?, apellido=?," +
                    " email=?, clave=?, dni=?, obra_social=?, nro_afiliado=?, estado=?" +
                    "WHERE id_paciente=?");

            preparedStatement.setString(1, paciente.getNombre());
            preparedStatement.setString(2, paciente.getApellido());
            preparedStatement.setString(3,paciente.getEmail());
            preparedStatement.setString(4, paciente.getClave());
            preparedStatement.setInt(5, paciente.getDni());
            preparedStatement.setString(6, paciente.getObra_social());
            preparedStatement.setInt(7,paciente.getNro_afiliado());
            preparedStatement.setBoolean(8,paciente.isEstado());
            preparedStatement.setInt(9,paciente.getId_paciente());

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
    public Paciente buscar(int id_paciente) throws DAOException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Paciente paciente = null;

        try {
            //1. levantar el driver y conectarnos
            Class.forName(DB_JDBC_DRIVER); // cargar driver base de datos
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            //2. preparar sentencia SQL
            preparedStatement = connection.prepareStatement("SELECT * FROM Pacientes WHERE id_paciente=?");
            preparedStatement.setInt(1,id_paciente);

            //3. ejecutar la sentencia
            ResultSet rs = preparedStatement.executeQuery();

            //evaluamos los resultados
            while (rs.next()){
                paciente = new Paciente();
                paciente.setId_paciente(rs.getInt("id_paciente"));
                paciente.setNombre(rs.getString("nombre"));
                paciente.setApellido(rs.getString("apellido"));
                paciente.setEmail(rs.getString("email"));
                paciente.setClave(rs.getString("clave"));
                paciente.setDni(rs.getInt("dni"));
                paciente.setObra_social(rs.getString("obra_social"));
                paciente.setNro_afiliado(rs.getInt("nro_afiliado"));
                paciente.setEstado(rs.getBoolean("estado"));
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
        return paciente;
    }

    @Override
    public ArrayList buscarTodos() throws DAOException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Paciente paciente = null;
        ArrayList pacientes = new ArrayList();  //este metodo devuelve un ArrayList que contiene una colección de objetos Paciente

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
                paciente = new Paciente();
                paciente.setId_paciente(rs.getInt("id_paciente"));
                paciente.setNombre(rs.getString("nombre"));
                paciente.setApellido(rs.getString("apellido"));
                paciente.setEmail(rs.getString("email"));
                paciente.setClave(rs.getString("clave"));
                paciente.setDni(rs.getInt("dni"));
                paciente.setObra_social(rs.getString("obra_social"));
                paciente.setNro_afiliado(rs.getInt("nro_afiliado"));
                paciente.setEstado(rs.getBoolean("estado"));
                pacientes.add(paciente);
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
        return pacientes; //devuelve un ArrayList
    }
}
