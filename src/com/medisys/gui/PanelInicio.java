package com.medisys.gui;

import javax.swing.*;
import java.awt.*;


public class PanelInicio extends JPanel {

    JLabel jLabel1, menupath; //etiquetas

    PanelInicio(){
        jLabel1 = new JLabel();
        jLabel1.setFont(new Font("Helbetica",Font.PLAIN,15));
        jLabel1.setText("Bienvenidos a MediSys");
        menupath = new JLabel("  Inicio");
        menupath.setFont(new Font("Helbetica",Font.PLAIN,15));

        this.setLayout(new BorderLayout());      //layout del panel inicio
        this.add(menupath,BorderLayout.NORTH);      //agregue el label menupath al NORTE
        this.add(jLabel1,BorderLayout.CENTER);      //agregue el label1 al CENTRO
    }

}
