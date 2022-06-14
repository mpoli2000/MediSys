package com.medisys.gui;

import com.medisys.entidades.Paciente;
import com.medisys.service.PacienteService;
import com.medisys.service.ServiceException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PanelListaPacientes extends JPanel {

    //grilla, listado
    private JTable jtable;
    private DefaultTableModel contenidoTabla;
    private JScrollPane scrollPane;

    //botonera
    JButton jButtonEliminar;
    JButton jButtonModificar;
    JButton jButtonNuevo;
    private JPanel panelBotonera;

    //Cada panel conoce al panelManager
    private PanelManager panelManager;

    public void armarPanelListadoPacientes(PanelManager panelManager){
        this.panelManager = panelManager;
        setLayout(new BorderLayout());

        //Grilla
        contenidoTabla = new DefaultTableModel();
        jtable = new JTable(contenidoTabla);
        scrollPane = new JScrollPane();
        scrollPane.setViewportView(jtable);

        contenidoTabla.addColumn("ID");
        contenidoTabla.addColumn("NOMBRE");
        contenidoTabla.addColumn("APELLIDO");
        contenidoTabla.addColumn("EMAIL");
        contenidoTabla.addColumn("CLAVE");
        contenidoTabla.addColumn("DNI");
        contenidoTabla.addColumn("ID OBRA SOCIAL");
        contenidoTabla.addColumn("OBRA SOCIAL");
        contenidoTabla.addColumn("NRO AFILIADO");
        contenidoTabla.addColumn("ESTADO");

        PacienteService pacienteService = new PacienteService();

        ArrayList pacientes = null;
        try {
            pacientes = pacienteService.buscarTodos();
        } catch (ServiceException e) {
            e.printStackTrace();
            //Dialog
            JOptionPane.showMessageDialog(null,"Ha sucedido un error al guardar un paciente "
                    + e.getMessage(), "Error",JOptionPane.ERROR_MESSAGE);
        }
        for(Object obj:pacientes){
            Paciente paciente = (Paciente) obj;
            Object[] row = new Object[10];
            row[0] = paciente.getId_paciente();
            row[1] = paciente.getNombre();
            row[2] = paciente.getApellido();
            row[3] = paciente.getEmail();
            row[4] = paciente.getClave();
            row[5] = paciente.getDni();
            row[6] = paciente.getId_obra_social();
            row[7] = paciente.getObra_social();
            row[8] = paciente.getNro_afiliado();
            row[9] = paciente.isEstado();

            contenidoTabla.addRow(row);
        }
        //Botonera
        panelBotonera = new JPanel();
        jButtonEliminar = new JButton("ELIMIINAR");
        jButtonModificar = new JButton("MODIFICAR");
        jButtonNuevo = new JButton("NUEVO");
        panelBotonera.add(jButtonEliminar);
        panelBotonera.add(jButtonModificar);
        panelBotonera.add(jButtonNuevo);

        add(scrollPane, BorderLayout.CENTER);
        add(panelBotonera, BorderLayout.SOUTH);

        //Cuando hacemos clic sobre el boton eliminar buscamos en la grilla (table) el id de la
        //fila seleccionada y a traves de un objeto service eliminamos al paciente
        jButtonEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PacienteService pacienteService1 = new PacienteService();

                int idEliminar = (int) jtable.getValueAt(jtable.getSelectedRow(),0);
                try {
                    pacienteService1.eliminarPaciente(idEliminar);
                    refrezcarListado();
                } catch (ServiceException serviceException) {
                    serviceException.printStackTrace();
                    //Dialog
                    JOptionPane.showMessageDialog(null,"Ha sucedido un error al eliminar un paciente "
                            + serviceException.getMessage(), "Error",JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        //Cuando hacemos clic sobre el boton nuevo creamos una ventana es decir un frame
        //y le colocamos adentro el panel del formulario de paciente para poder crear un nuevo paciente
        PanelListaPacientes panel = this;
        jButtonNuevo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //En lugar de crear un frame y agregarle el panel del formulario le delego
                // toda esa responsabilidad al panel manager
                panelManager.mostrarFormularioPaciente();
            }
        });

        //Con el id de la fila que seleccionamos para modificar a ese paciente
        //traemos al paciente de la base de datos para tener un objeto paciente con todos esos datos
        jButtonModificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int idModificar = (int) jtable.getValueAt(jtable.getSelectedRow(),0);
                PacienteService pacienteService1 = new PacienteService();

                Paciente paciente = null;

                try {
                    //lo buscamos
                    paciente = pacienteService1.buscarPaciente(idModificar);
                } catch (ServiceException serviceException) {
                    serviceException.printStackTrace();
                    //Dialog
                    JOptionPane.showMessageDialog(null,"Ha sucedido un error al traer un paciente" +
                            "para modificarlo. Por favor, contactar al administrador: " + serviceException.getMessage(),
                            "Error",JOptionPane.ERROR_MESSAGE);
                }
                panelManager.mostrarFormularioPaciente(paciente);
            }
        });

    }
    public void refrezcarListado(){
        removeAll();
        armarPanelListadoPacientes(panelManager);
        validate();
        repaint();
    }
}
