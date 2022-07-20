package com.medisys.gui;

import com.medisys.entidades.Entidad;
import com.medisys.entidades.Medico;
import com.medisys.entidades.Paciente;
import com.medisys.service.EntidadService;
import com.medisys.service.ServiceException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PanelMedico extends JPanel implements ActionListener {
    JLabel jLabel;
    JButton jButtonNuevo, jButtonModificar, jButtonEliminar;

    JPanel panelBotonera, panelBotones;
    JPanel panelListado,panelFormulario;

    JTable jTable;
    DefaultTableModel contenidoTabla;
    JScrollPane scrollPane;

    JTextField jTextFieldId, jTextFieldNombre, jTextFieldApellido, jTextFieldEmail, jTextFieldClave, jTextFieldIdObraSocial, jTextFieldObraSocial;
    JButton jButtonGuardar, jButtonCancelar;

    PanelMedico(){

        jLabel = new JLabel();
        jLabel.setFont(new Font("Helbetica",Font.PLAIN,18));
        jLabel.setText("MEDICOS");

        listadoMedicos();

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

    public void listadoMedicos(){

        panelListado = new JPanel();
        panelListado.setLayout(new BorderLayout());

        contenidoTabla = new DefaultTableModel();
        jTable = new JTable(contenidoTabla);
        scrollPane = new JScrollPane();
        scrollPane.setViewportView(jTable);   // un scrollpane contiene una tabla y la tabla tiene un contenido

        contenidoTabla.addColumn("ID MEDICO");
        contenidoTabla.addColumn("NOMBRE");
        contenidoTabla.addColumn("APELLIDO");
        contenidoTabla.addColumn("EMAIL");
        contenidoTabla.addColumn("CLAVE");
        contenidoTabla.addColumn("ID OBRA SOCIAL");
        contenidoTabla.addColumn("OBRA SOCIAL");

        Entidad entidad = new Medico();
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
            Object[] row = new Object[7];     //creo un objeto fila con 6 columas/campos
            row[0] = ((Medico) entidad1).getId_medico();
            row[1] = ((Medico) entidad1).getNombre();
            row[2] = ((Medico) entidad1).getApellido();
            row[3] = ((Medico) entidad1).getEmail();
            row[4] = ((Medico) entidad1).getClave();
            row[5] = ((Medico) entidad1).getId_obra_social();
            row[6] = ((Medico) entidad1).getObra_social();

            contenidoTabla.addRow(row);
        }
        panelListado.add(scrollPane,BorderLayout.CENTER);
    }

    public void formularioMedico(){
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


    public void guardarMedico(){

        Entidad entidad3 = new Medico();

        ((Medico) entidad3).setId_medico(Integer.parseInt(jTextFieldId.getText()));
        ((Medico) entidad3).setNombre(jTextFieldNombre.getText());
        ((Medico) entidad3).setApellido(jTextFieldApellido.getText());
        ((Medico) entidad3).setEmail(jTextFieldEmail.getText());
        ((Medico) entidad3).setClave(jTextFieldClave.getText());
        ((Medico) entidad3).setId_obra_social(Integer.parseInt(jTextFieldId.getText()));
        ((Medico) entidad3).setObra_social(jTextFieldObraSocial.getText());

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
            Entidad entidad2 = new Medico();
            EntidadService entidadService2 = new EntidadService(entidad2);
            int idEliminar = (int) jTable.getValueAt(jTable.getSelectedRow(), 0);
            try {
                entidadService2.eliminar(idEliminar);
                this.remove(panelListado);
                listadoMedicos();
                this.add(panelListado, BorderLayout.CENTER);
                this.validate();
                this.repaint();

            } catch (ServiceException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Ha sucedido un error al eliminar un medico "
                        + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }


        }
        if (e.getSource() == jButtonNuevo) {
            System.out.println("NUEVO");
            jButtonNuevo.setEnabled(false);
            jButtonModificar.setEnabled(false);
            jButtonEliminar.setEnabled(false);
            formularioMedico();
            panelListado.add(panelFormulario,BorderLayout.EAST);
            this.validate();
            this.repaint();

        }

        if (e.getSource() == jButtonModificar) {
            System.out.println("MODIFICAR");
        }

        if (e.getSource() == jButtonGuardar) {
            System.out.println("GUARDAR");
            guardarMedico();
            this.remove(panelListado);
            listadoMedicos();
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
            listadoMedicos();
            this.add(panelListado, BorderLayout.CENTER);
            jButtonNuevo.setEnabled(true);
            jButtonModificar.setEnabled(true);
            jButtonEliminar.setEnabled(true);
            this.validate();
            this.repaint();
        }
    }
}
