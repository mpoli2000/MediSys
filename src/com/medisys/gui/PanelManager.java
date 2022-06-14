package com.medisys.gui;
import com.medisys.entidades.Paciente;

import javax.swing.*;

public class PanelManager {

    //El panel manager es quien conoce a todos los paneles
    private PanelListaPacientes panelListaPacientes;
    private PanelFormularioPaciente panelFormularioPaciente;
    //El panel manager es el unico que tiene al frame. Ya que en la aplicacio habra un unico frame
    //es decir, una unica ventana
    private JFrame frame;

    public void armarPanelManager(){
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panelFormularioPaciente = new PanelFormularioPaciente();
        panelFormularioPaciente.armarPanelFormularioPaciente(this);

        panelListaPacientes = new PanelListaPacientes();
        panelListaPacientes.armarPanelListadoPacientes(this);

        frame.setVisible(true);
        frame.pack();
    }

    public void mostrarFormularioPaciente(){
        panelFormularioPaciente.vaciarComponentes();
        mostrar(panelFormularioPaciente);
    }

    public void mostrarFormularioPaciente(Paciente paciente){
        panelFormularioPaciente.armarPanelFormularioPaciente(paciente);
        mostrar(panelFormularioPaciente);
    }

    public void mostrarListaPacientes(){
        panelListaPacientes.refrezcarListado();
        mostrar(panelListaPacientes);
    }

    private void mostrar(JPanel panel){
        frame.getContentPane().removeAll();
        frame.getContentPane().add(panel);
        frame.getContentPane().validate();
        frame.getContentPane().repaint();
        frame.pack();
    }
}
