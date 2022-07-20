package com.medisys.gui;

import com.medisys.entidades.Consultorio;
import com.medisys.entidades.Entidad;
import com.medisys.entidades.ObraSocial;
import com.medisys.service.EntidadService;
import com.medisys.service.ServiceException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PanelObraSocial extends JPanel implements ActionListener {
    JLabel jLabel;
    JButton jButtonNuevo, jButtonModificar, jButtonEliminar;

    JPanel panelBotonera, panelBotones;
    JPanel panelListado,panelFormulario;

    JTable jTable;
    DefaultTableModel contenidoTabla;
    JScrollPane scrollPane;

    JTextField jTextFieldId, jTextFieldNombre;
    JButton jButtonGuardar, jButtonCancelar;

    PanelObraSocial(){

        jLabel = new JLabel();
        jLabel.setFont(new Font("Helbetica",Font.PLAIN,18));
        jLabel.setText("OBRAS SOCIALES");

        listadoObrasSociales();

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

    public void listadoObrasSociales(){

        panelListado = new JPanel();
        panelListado.setLayout(new BorderLayout());

        contenidoTabla = new DefaultTableModel();
        jTable = new JTable(contenidoTabla);
        scrollPane = new JScrollPane();
        scrollPane.setViewportView(jTable);   // un scrollpane contiene una tabla y la tabla tiene un contenido

        contenidoTabla.addColumn("ID OBRA SOCIAL");
        contenidoTabla.addColumn("NOMBRE");

        Entidad entidad = new ObraSocial();
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
            Object[] row = new Object[2];     //creo un objeto fila con columas/campos
            row[0] = ((ObraSocial) entidad1).getId_obra_social();
            row[1] = ((ObraSocial) entidad1).getNombre();


            contenidoTabla.addRow(row);
        }
        panelListado.add(scrollPane,BorderLayout.CENTER);
    }

    public void formularioObraSocial(){
        JLabel jLabelId, jLabelNombre;


        jLabelId = new JLabel("ID:");
        jLabelNombre = new JLabel("NOMBRE");

        jTextFieldId = new JTextField(10);
        jTextFieldNombre = new JTextField(20);

        panelFormulario = new JPanel();
        panelFormulario.setLayout(new BorderLayout());

        JPanel panelComponentes = new JPanel();
        panelComponentes.setLayout(new GridLayout(2,2));

        panelComponentes.add(jLabelId);
        panelComponentes.add(jTextFieldId);
        panelComponentes.add(jLabelNombre);
        panelComponentes.add(jTextFieldNombre);

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


    public void guardarObraSocial(){

        Entidad entidad3 = new ObraSocial();

        ((ObraSocial) entidad3).setId_obra_social(Integer.parseInt(jTextFieldId.getText()));
        ((ObraSocial) entidad3).setNombre(jTextFieldNombre.getText());


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
            Entidad entidad2 = new ObraSocial();
            EntidadService entidadService2 = new EntidadService(entidad2);
            int idEliminar = (int) jTable.getValueAt(jTable.getSelectedRow(), 0);
            try {
                entidadService2.eliminar(idEliminar);
                this.remove(panelListado);
                listadoObrasSociales();
                this.add(panelListado, BorderLayout.CENTER);
                this.validate();
                this.repaint();

            } catch (ServiceException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Ha sucedido un error al eliminar una obra social "
                        + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }


        }
        if (e.getSource() == jButtonNuevo) {
            System.out.println("NUEVO");
            jButtonNuevo.setEnabled(false);
            jButtonModificar.setEnabled(false);
            jButtonEliminar.setEnabled(false);
            formularioObraSocial();
            panelListado.add(panelFormulario,BorderLayout.EAST);
            this.validate();
            this.repaint();

        }

        if (e.getSource() == jButtonModificar) {
            System.out.println("MODIFICAR");
        }

        if (e.getSource() == jButtonGuardar) {
            System.out.println("GUARDAR");
            guardarObraSocial();
            this.remove(panelListado);
            listadoObrasSociales();
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
            listadoObrasSociales();
            this.add(panelListado, BorderLayout.CENTER);
            jButtonNuevo.setEnabled(true);
            jButtonModificar.setEnabled(true);
            jButtonEliminar.setEnabled(true);
            this.validate();
            this.repaint();
        }
    }
}
