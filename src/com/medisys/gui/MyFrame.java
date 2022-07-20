package com.medisys.gui;
import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {

    MyPanel panel1;

    MyFrame() { //constructor

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("MediSys: Sistema Médico");
        this.setFont(new Font("Helvetica", Font.PLAIN, 12));
        this.setLayout(new BorderLayout());
        this.setSize(900, 600);
        this.setLocationRelativeTo(null); //centra la ventana en la pantalla

        panel1 = new MyPanel(); //creo una instancia de la clase MyPanel

        this.add(panel1); // le agrego el panel dentro del frame
        this.setVisible(true); //hago visible la ventana
    }
}