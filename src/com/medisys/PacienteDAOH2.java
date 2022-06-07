package com.medisys;
import java.sql.*;
import java.util.ArrayList;

public class PacienteDAOH2 implements IPacienteDAO{

    private String DB_JDBC_DRIVER = "org.h2.Driver"; //driver base H2
    private String DB_URL = "jdbc:h2:~/MediSys";
    private String DB_USER = "mateo";
    private String DB_PASSWORD = "";


    @Override
    public void guardar(Paciente paciente) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            //1. levantar el driver y conectarnos
            Class.forName(DB_JDBC_DRIVER); // cargar driver base de datos
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            //2. preparar sentencia SQL
            preparedStatement = connection.prepareStatement("INSERT INTO Pacientes VALUES (?,?,?,?,?,?,?,?,?)");

            preparedStatement.setInt(1, paciente.getId_paciente());
            preparedStatement.setString(2, paciente.getNombre());
            preparedStatement.setString(3, paciente.getApellido());
            preparedStatement.setString(4,paciente.getEmail());
            preparedStatement.setString(5, paciente.getClave());
            preparedStatement.setInt(6, paciente.getDni());
            preparedStatement.setString(7, paciente.getObra_social());
            preparedStatement.setInt(8,paciente.getNro_afiliado());
            preparedStatement.setBoolean(9,paciente.isEstado());

            //3. ejecutar la sentencia
            int i = preparedStatement.executeUpdate();

            //4. evaluamos los resultados
            System.out.println("Registros insertados: " + i);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override
    public void eliminar(int id_paciente) {
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
    } finally {
        try {
            preparedStatement.close();
        } catch (SQLException e2) {
            e2.printStackTrace();
        }
    }

    }

    @Override
    public Paciente buscar(int id_paciente) {

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
                paciente.setNombre(rs.getString("nombre"));
                paciente.setApellido(rs.getString("apellido"));
                paciente.setEmail(rs.getString("email"));
                paciente.setClave(rs.getString("clave"));
                paciente.setDni(rs.getInt("dni"));
                paciente.setObra_social(rs.getString("obra_social"));
                paciente.setNro_afiliado(rs.getInt("nro_afiliado"));
                paciente.setEstado(rs.getBoolean("estado"));
                System.out.println(paciente.toString()); //no es necesario poner.toString()
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
        }
        return paciente;
    }

    @Override
    public ArrayList buscarTodos() {

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

                System.out.println(paciente.toString()); //no es necesario poner.toString()
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
        }
        return pacientes; //devuelve un ArrayList
    }
}
