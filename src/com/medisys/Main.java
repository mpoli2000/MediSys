package com.medisys;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Usuario user1 = new Paciente();
        user1.nombre("Mateo");
        System.out.println(((Paciente)user1).toString());

        Paciente user2 = new Paciente();
        System.out.println(user2.toString());

        user1.crearUsuario();














 /*       int i =0;
        Scanner myscanner = new Scanner(System.in);  // Create a Scanner object

        while (i != 3) {

            System.out.println("Bienvenido al sistema de reserva MediSys");
            System.out.println("1. Registrarse");
            System.out.println("2. Ingresar");
            System.out.println("3. Salir" );
            System.out.println("Ingrese una opción para continuar:" );
            i = myscanner.nextInt();  // Read user input

            switch (i) {
                case 1 -> {

                    while (i !=3 && i !=4) {
                        System.out.println("Registrar un Medico o un Paciente ?");
                        System.out.println("1. Medico ");
                        System.out.println("2. Paciente");
                        System.out.println("3. Salir");
                        System.out.println("4. Atras");

                        System.out.println("Seleccione una de las opciones:");
                        i = myscanner.nextInt();  // ingresar opción

                        switch (i) {
                            case 1 ->
                                System.out.println("Crear Medico");

                            case 2 ->
                                System.out.println("Crear Paciente");
                            default -> {
                            }
                        }
                    }
                }
                case 2 ->{
                    System.out.println("usuario o email:");
                    String usuario = myscanner.nextLine();  // ingresar usuario
                    System.out.println("clave:");
                    String clave = myscanner.nextLine();  // ingresar clave

                    System.out.println("1. Ok");
                    System.out.println("2. Cancelar");
                    System.out.println("3. Salir");

                    //verificar usuario y clave ....

                }
                default ->{}
            }
        }*/
    }

}
