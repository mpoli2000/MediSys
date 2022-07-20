package com.medisys.gui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyPanel extends JPanel implements ActionListener {

    PanelMenu menu;
    PanelInicio panelInicio;
    PanelPaciente panelPaciente;
    PanelMedico panelMedico;
    PanelConsultorio panelConsultorio;
    PanelObraSocial panelObraSocial;
    PanelRecurso panelRecurso;
    PanelTurno panelTurno;
    JPanel container;

    public MyPanel(){

        menu = new PanelMenu(); //creo un panelmenu
        panelInicio = new PanelInicio(); //creo un panelinicio
        panelPaciente = new PanelPaciente();
        panelMedico = new PanelMedico();
        panelConsultorio = new PanelConsultorio();
        panelObraSocial = new PanelObraSocial();
        panelRecurso = new PanelRecurso();
        panelTurno = new PanelTurno();
        container = new JPanel(); //creo un panel contenedor

        container.setLayout(new BorderLayout());

        this.setLayout(new BorderLayout());
        this.setBackground(Color.blue);
        this.add(menu,BorderLayout.WEST);
        this.add(container,BorderLayout.CENTER);
        container.add(panelTurno);           //agrego el panel inicio dentro del panel contenedor


        menu.buttons.get(0).addActionListener(this);  //action listener de inicio
        menu.buttons.get(1).addActionListener(this); //paciente
        menu.buttons.get(2).addActionListener(this);   //medico
        menu.buttons.get(3).addActionListener(this);   //consultorio
        menu.buttons.get(4).addActionListener(this);    //obra social
        menu.buttons.get(5).addActionListener(this);    //Recursos
        menu.buttons.get(6).addActionListener(this);   //turnos

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==menu.buttons.get(0)){
            container.removeAll();
            panelInicio = new PanelInicio();
            container.add(panelInicio);
            container.validate();
            this.repaint();
        }
        if(e.getSource()==menu.buttons.get(1)){
            container.removeAll();
            panelPaciente = new PanelPaciente();
            container.add(panelPaciente);
            container.validate();
            this.repaint();
        }
        if(e.getSource()==menu.buttons.get(2)){
            container.removeAll();
            panelMedico = new PanelMedico();
            container.add(panelMedico);
            container.validate();
            this.repaint();
        }
        if(e.getSource()==menu.buttons.get(3)){
            container.removeAll();
            panelConsultorio = new PanelConsultorio();
            container.add(panelConsultorio);
            container.validate();
            this.repaint();
        }
        if(e.getSource()==menu.buttons.get(4)){
            container.removeAll();
            panelObraSocial = new PanelObraSocial();
            container.add(panelObraSocial);
            container.validate();
            this.repaint();
        }
        if(e.getSource()==menu.buttons.get(5)){
            container.removeAll();
            panelRecurso = new PanelRecurso();
            container.add(panelRecurso);
            container.validate();
            this.repaint();
        }
        if(e.getSource()==menu.buttons.get(6)){
            container.removeAll();
            panelTurno = new PanelTurno();
            container.add(panelTurno);
            container.validate();
            this.repaint();
        }
    }
}
