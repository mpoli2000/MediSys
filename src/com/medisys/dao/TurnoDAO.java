package com.medisys.dao;

import com.medisys.entidades.Entidad;
import com.medisys.entidades.Turno;


import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class TurnoDAO implements IEntidadDAO {

    private String DB_JDBC_DRIVER = "org.h2.Driver"; //driver base H2
    private String DB_URL = "jdbc:h2:~/MediSys";
    private String DB_USER = "mateo";
    private String DB_PASSWORD = "";

    public TurnoDAO(){
        System.out.println("Ejecucion del constructor TurnoDAO");
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
            preparedStatement = connection.prepareStatement("INSERT INTO Turnos VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)");
            preparedStatement.setInt(1, ((Turno)entidad).getId_turno());
            preparedStatement.setTimestamp(2, Timestamp.valueOf(((Turno)entidad).getFecha_turno()));
            preparedStatement.setInt(3, ((Turno)entidad).getId_consultorio());
            preparedStatement.setString(4, ((Turno)entidad).getConsultorio());
            preparedStatement.setInt(5, ((Turno)entidad).getId_medico());
            preparedStatement.setString(6, ((Turno)entidad).getMedico());
            preparedStatement.setString(7, ((Turno)entidad).getOs_medico());
            preparedStatement.setInt(8, ((Turno)entidad).getId_paciente());
            preparedStatement.setString(9 ,((Turno)entidad).getPaciente());
            preparedStatement.setString(10, ((Turno)entidad).getOs_paciente());
            preparedStatement.setInt(11, ((Turno)entidad).getHonorario());
            preparedStatement.setFloat(12, ((Turno)entidad).getDescuento());
            preparedStatement.setFloat(13, ((Turno)entidad).getSaldo());

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
            preparedStatement = connection.prepareStatement("UPDATE Turnos SET fecha_turno=?, id_consultorio=?," +
                    " consultorio=?, id_medico=?, medico=?, os_medico=?, id_paciente=?, paciente=?, os_paciente=?," +
                    " honorario=?, descuento=?, saldo=? WHERE id_turno=?");

            preparedStatement.setTimestamp(1, Timestamp.valueOf(((Turno)entidad).getFecha_turno()));
            preparedStatement.setInt(2, ((Turno)entidad).getId_consultorio());
            preparedStatement.setString(3, ((Turno)entidad).getConsultorio());
            preparedStatement.setInt(4, ((Turno)entidad).getId_medico());
            preparedStatement.setString(5, ((Turno)entidad).getMedico());
            preparedStatement.setString(6, ((Turno)entidad).getOs_medico());
            preparedStatement.setInt(7, ((Turno)entidad).getId_paciente());
            preparedStatement.setString(8,((Turno)entidad).getPaciente());
            preparedStatement.setString(9, ((Turno)entidad).getOs_paciente());
            preparedStatement.setInt(10, ((Turno)entidad).getHonorario());
            preparedStatement.setFloat(11, ((Turno)entidad).getDescuento());
            preparedStatement.setFloat(12, ((Turno)entidad).getSaldo());
            preparedStatement.setInt(13, ((Turno)entidad).getId_turno());

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
    public void eliminar(int id_turno) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            //1. levantar el driver y conectarnos
            Class.forName(DB_JDBC_DRIVER); // cargar driver base de datos
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            //2. preparar sentencia SQL
            preparedStatement = connection.prepareStatement("DELETE FROM Turnos WHERE id_turno=?");
            preparedStatement.setInt(1,id_turno);


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
    public Entidad buscar(int id_turno) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Entidad entidad = null;

        try {
            //1. levantar el driver y conectarnos
            Class.forName(DB_JDBC_DRIVER); // cargar driver base de datos
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            //2. preparar sentencia SQL
            preparedStatement = connection.prepareStatement("SELECT * FROM Turnos WHERE id_turno=?");
            preparedStatement.setInt(1,id_turno);

            //3. ejecutar la sentencia
            ResultSet rs = preparedStatement.executeQuery();

            //evaluamos los resultados
            while (rs.next()){
                entidad = new Turno();
                ((Turno) entidad).setId_turno(rs.getInt("id_turno"));
                ((Turno) entidad).setFecha_turno(rs.getTimestamp("fecha_turno").toLocalDateTime());
                ((Turno) entidad).setId_consultorio(rs.getInt("id_consultorio"));
                ((Turno) entidad).setConsultorio(rs.getString("consultorio"));
                ((Turno) entidad).setId_medico(rs.getInt("id_medico"));
                ((Turno) entidad).setMedico(rs.getString("medico"));
                ((Turno) entidad).setOs_medico(rs.getString("os_medico"));
                ((Turno) entidad).setId_paciente(rs.getInt("id_paciente"));
                ((Turno) entidad).setPaciente(rs.getString("paciente"));
                ((Turno) entidad).setOs_paciente(rs.getString("os_paciente"));
                ((Turno) entidad).setHonorario(rs.getInt("honorario"));
                ((Turno) entidad).setDescuento(rs.getFloat("descuento"));
                ((Turno) entidad).setSaldo(rs.getFloat("saldo"));
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
            preparedStatement = connection.prepareStatement("SELECT * FROM Turnos");

            //3. ejecutar la sentencia
            ResultSet rs = preparedStatement.executeQuery();

            //evaluamos los resultados
            while (rs.next()){
                entidad = new Turno();
                ((Turno) entidad).setId_turno(rs.getInt("id_turno"));
                ((Turno) entidad).setFecha_turno(rs.getTimestamp("fecha_turno").toLocalDateTime());
                ((Turno) entidad).setId_consultorio(rs.getInt("id_consultorio"));
                ((Turno) entidad).setConsultorio(rs.getString("consultorio"));
                ((Turno) entidad).setId_medico(rs.getInt("id_medico"));
                ((Turno) entidad).setMedico(rs.getString("medico"));
                ((Turno) entidad).setOs_medico(rs.getString("os_medico"));
                ((Turno) entidad).setId_paciente(rs.getInt("id_paciente"));
                ((Turno) entidad).setPaciente(rs.getString("paciente"));
                ((Turno) entidad).setOs_paciente(rs.getString("os_paciente"));
                ((Turno) entidad).setHonorario(rs.getInt("honorario"));
                ((Turno) entidad).setDescuento(rs.getFloat("descuento"));
                ((Turno) entidad).setSaldo(rs.getFloat("saldo"));
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
