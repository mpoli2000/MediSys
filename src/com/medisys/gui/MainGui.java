package com.medisys.gui;
import javax.swing.*;
import java.awt.*;

public class MainGui {
    public static void main(String[] args) {
        System.out.println("Interfaces Graficas");

        JFrame frame = new JFrame(); //defino la ventana
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //cierra la ventana cdo aprieto x

        JTextField textField = new JTextField(20); //20 caracteres
        JButton jButton = new JButton("Guardar"); //boton de guardar

        JPanel panel = new JPanel(); //defino un panel que contenga los elementos
        panel.add(textField);
        panel.add(jButton);

        frame.getContentPane().add(panel);// lea agrego el panel con sus elementos al frame
        //layout por defecto es flow (uno alado del otro
        frame.pack(); //metodo pack, cdo se haga visible definir el tamaño para que se vean los componentes dentro
        frame.setVisible(true);



    }

}
