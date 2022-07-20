package com.medisys.gui;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PanelMenu extends JPanel {

    String[] buttonList = {"Inicio",
            "Pacientes", "Médicos", "Consultorios", "Obras Sociales", "Recursos",
            "Turnos"};//lista de strings con cabeceras del menu

    public ArrayList<JButton> buttons = new ArrayList(); //lista de objetos botones
    JButton JB; //creo una variable del tipo JButton

    PanelMenu() {

        this.setLayout(null);
        this.setBackground(new Color(50, 60, 70));
        this.setPreferredSize(new Dimension(200, 100));

        int i = 0;
        for (String str : buttonList) {
            buttons.add(JB = new JButton());
            JB.setText(buttonList[i]);
            JB.setFont(new Font("Helvetica", Font.PLAIN, 15));
            JB.setBackground(new Color(7, 33, 70));
            JB.setBounds(0, i * 50, 200, 50);
            JB.setBorderPainted(false);
            JB.setForeground(new Color(163, 173, 187));
            JB.setOpaque(true);
            JB.setFocusable(false);
            JB.setHorizontalAlignment(JButton.LEFT);   //
            this.add(JB);
            i++;
        }

    }
}
