package com.medisys.gui;

import com.medisys.entidades.Entidad;
import com.medisys.entidades.Paciente;
import com.medisys.service.EntidadService;
import com.medisys.service.ServiceException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PanelPaciente extends JPanel implements ActionListener {

    JLabel jLabel;
    JButton jButtonNuevo, jButtonModificar, jButtonEliminar;

    JPanel panelBotonera, panelBotones;
    JPanel panelListado,panelFormulario;

    JTable jTable;
    DefaultTableModel contenidoTabla;
    JScrollPane scrollPane;

    JTextField jTextFieldId, jTextFieldNombre, jTextFieldApellido, jTextFieldEmail, jTextFieldClave, jTextFieldIdObraSocial, jTextFieldObraSocial;
    JButton jButtonGuardar, jButtonCancelar;

    PanelPaciente(){

        jLabel = new JLabel();
        jLabel.setFont(new Font("Helbetica",Font.PLAIN,18));
        jLabel.setText("PACIENTES");

        listadoPacientes();

        //botonera
        panelBotonera = new JPanel();
        panelBotonera.setLayout(new FlowLayout());
        jButtonEliminar = new JButton("ELIMINAR");
        jButtonModificar = new JButton("MODIFICAR");
        jButtonNuevo = new JButton("NUEVO");

        panelBotonera.add(jButtonNuevo);
        panelBotonera.add(jButtonModificar);
        panelBotonera.add(jButtonEliminar);

        this.setLayout(new BorderLayout());
        this.add(jLabel,BorderLayout.NORTH);
        this.add(panelListado, BorderLayout.CENTER);
        this.add(panelBotonera, BorderLayout.SOUTH);

        jButtonEliminar.addActionListener(this);
        jButtonNuevo.addActionListener(this);
        jButtonModificar.addActionListener(this);

    }

    public void listadoPacientes(){

        panelListado = new JPanel();
        panelListado.setLayout(new BorderLayout());

        contenidoTabla = new DefaultTableModel();
        jTable = new JTable(contenidoTabla);
        scrollPane = new JScrollPane();
        scrollPane.setViewportView(jTable);   // un scrollpane contiene una tabla y la tabla tiene un contenido

        contenidoTabla.addColumn("ID PACIENTE");
        contenidoTabla.addColumn("NOMBRE");
        contenidoTabla.addColumn("APELLIDO");
        contenidoTabla.addColumn("EMAIL");
        contenidoTabla.addColumn("CLAVE");
        contenidoTabla.addColumn("ID OBRA SOCIAL");
        contenidoTabla.addColumn("OBRA SOCIAL");

        Entidad entidad = new Paciente();
        EntidadService entidadService = new EntidadService(entidad);
        ArrayList entidades = null;
        try {
            entidades = entidadService.buscarTodos();
        } catch (ServiceException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"Ha sucedido un error "
                    + e.getMessage(), "Error",JOptionPane.ERROR_MESSAGE);
        }

        for(Object obj:entidades) {
            Entidad entidad1 = (Entidad)obj;
            Object[] row = new Object[7];     //creo un objeto fila con columas/campos
            row[0] = ((Paciente) entidad1).getId_paciente();
            row[1] = ((Paciente) entidad1).getNombre();
            row[2] = ((Paciente) entidad1).getApellido();
            row[3] = ((Paciente) entidad1).getEmail();
            row[4] = ((Paciente) entidad1).getClave();
            row[5] = ((Paciente) entidad1).getId_obra_social();
            row[6] = ((Paciente) entidad1).getObra_social();

            contenidoTabla.addRow(row);
        }
        panelListado.add(scrollPane,BorderLayout.CENTER);
    }

    public void formularioPaciente(){
        JLabel jLabelId, jLabelNombre, jLabelApellido, jLabelEmail, jLabelClave, jLabelIdObraSocial, jLabelObraSocial;


        jLabelId = new JLabel("ID:");
        jLabelNombre = new JLabel("NOMBRE");
        jLabelApellido = new JLabel("APELLIDO:");
        jLabelEmail = new JLabel("EMAIL:");
        jLabelClave = new JLabel("CLAVE:");
        jLabelIdObraSocial = new JLabel("ID OBRA SOCIAL:");
        jLabelObraSocial = new JLabel("OBRA SOCIAL:");

        jTextFieldId = new JTextField(10);
        jTextFieldNombre = new JTextField(20);
        jTextFieldApellido = new JTextField(20);
        jTextFieldEmail = new JTextField(20);
        jTextFieldClave = new JTextField(20);
        jTextFieldIdObraSocial = new JTextField(20);
        jTextFieldObraSocial = new JTextField(20);

        panelFormulario = new JPanel();
        panelFormulario.setLayout(new BorderLayout());

        JPanel panelComponentes = new JPanel();
        panelComponentes.setLayout(new GridLayout(7,2));

        panelComponentes.add(jLabelId);
        panelComponentes.add(jTextFieldId);
        panelComponentes.add(jLabelNombre);
        panelComponentes.add(jTextFieldNombre);
        panelComponentes.add(jLabelApellido);
        panelComponentes.add(jTextFieldApellido);
        panelComponentes.add(jLabelEmail);
        panelComponentes.add(jTextFieldEmail);
        panelComponentes.add(jLabelClave);
        panelComponentes.add(jTextFieldClave);
        panelComponentes.add(jLabelIdObraSocial);
        panelComponentes.add(jTextFieldIdObraSocial);
        panelComponentes.add(jLabelObraSocial);
        panelComponentes.add(jTextFieldObraSocial);

        jButtonGuardar = new JButton("GUARDAR");
        jButtonCancelar = new JButton("CANCELAR");

        panelBotones = new JPanel();
        panelBotones.add(jButtonGuardar);
        panelBotones.add(jButtonCancelar);

        panelFormulario.add(panelComponentes,BorderLayout.CENTER);
        panelFormulario.add(panelBotones,BorderLayout.SOUTH);

        jButtonGuardar.addActionListener(this);
        jButtonCancelar.addActionListener(this);

    }


    public void guardarPaciente(){

        Entidad entidad3 = new Paciente();

        ((Paciente) entidad3).setId_paciente(Integer.parseInt(jTextFieldId.getText()));
        ((Paciente) entidad3).setNombre(jTextFieldNombre.getText());
        ((Paciente) entidad3).setApellido(jTextFieldApellido.getText());
        ((Paciente) entidad3).setEmail(jTextFieldEmail.getText());
        ((Paciente) entidad3).setClave(jTextFieldClave.getText());
        ((Paciente) entidad3).setId_obra_social(Integer.parseInt(jTextFieldId.getText()));
        ((Paciente) entidad3).setObra_social(jTextFieldObraSocial.getText());

        EntidadService entidadService3 = new EntidadService(entidad3);
        try {
            entidadService3.guardar();
        } catch (ServiceException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"Ha sucedido un error al guardar "
                    + e.getMessage(), "Error",JOptionPane.ERROR_MESSAGE);
        }


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jButtonEliminar) {
            System.out.println("ELIMINAR");
            Entidad entidad2 = new Paciente();
            EntidadService entidadService2 = new EntidadService(entidad2);
            int idEliminar = (int) jTable.getValueAt(jTable.getSelectedRow(), 0);
            try {
                entidadService2.eliminar(idEliminar);
                this.remove(panelListado);
                listadoPacientes();
                this.add(panelListado, BorderLayout.CENTER);
                this.validate();
                this.repaint();

            } catch (ServiceException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Ha sucedido un error al eliminar un paciente "
                        + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }


        }
        if (e.getSource() == jButtonNuevo) {
            System.out.println("MNUEVO");
            jButtonNuevo.setEnabled(false);
            jButtonModificar.setEnabled(false);
            jButtonEliminar.setEnabled(false);
            formularioPaciente();
            panelListado.add(panelFormulario,BorderLayout.EAST);
            this.validate();
            this.repaint();

        }

        if (e.getSource() == jButtonModificar) {
            System.out.println("MODIFICAR");
        }

        if (e.getSource() == jButtonGuardar) {
            System.out.println("GUARDAR");
            guardarPaciente();
            this.remove(panelListado);
            listadoPacientes();
            this.add(panelListado, BorderLayout.CENTER);
            jButtonNuevo.setEnabled(true);
            jButtonModificar.setEnabled(true);
            jButtonEliminar.setEnabled(true);
            this.validate();
            this.repaint();

       }

        if (e.getSource() == jButtonCancelar) {
            System.out.println("CANCELAR");
            this.remove(panelListado);
            listadoPacientes();
            this.add(panelListado, BorderLayout.CENTER);
            jButtonNuevo.setEnabled(true);
            jButtonModificar.setEnabled(true);
            jButtonEliminar.setEnabled(true);
            this.validate();
            this.repaint();
        }
    }
}
