package com.medisys.gui;

import com.medisys.entidades.Entidad;
import com.medisys.entidades.Paciente;
import com.medisys.entidades.Recurso;
import com.medisys.service.EntidadService;
import com.medisys.service.ServiceException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.JavaBean;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class PanelRecurso extends JPanel implements ActionListener {
    JLabel jLabel;
    JButton jButtonNuevo, jButtonModificar, jButtonEliminar;

    JPanel panelBotonera, panelBotones;
    JPanel panelListado,panelFormulario;

    JTable jTable;
    DefaultTableModel contenidoTabla;
    JScrollPane scrollPane;

    JTextField jTextFieldIdRecurso, jTextFieldDia, jTextFieldIdConsultorio, jTextFieldConsultorio,
            jTextFieldIdMedico, jTextFieldMedico, jTextFieldFechaInicial, jTextFieldFechaFinal;
    JButton jButtonGuardar, jButtonCancelar;

    PanelRecurso(){

        jLabel = new JLabel();
        jLabel.setFont(new Font("Helbetica",Font.PLAIN,18));
        jLabel.setText("RECURSOS");

        listadoRecursos();

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

    public void listadoRecursos(){

        panelListado = new JPanel();
        panelListado.setLayout(new BorderLayout());

        contenidoTabla = new DefaultTableModel();
        jTable = new JTable(contenidoTabla);
        scrollPane = new JScrollPane();
        scrollPane.setViewportView(jTable);   // un scrollpane contiene una tabla y la tabla tiene un contenido

        contenidoTabla.addColumn("ID RECURSO");
        contenidoTabla.addColumn("DIA");
        contenidoTabla.addColumn("ID CONSULTORIO");
        contenidoTabla.addColumn("CONSULTORIO");
        contenidoTabla.addColumn("ID MEDICO");
        contenidoTabla.addColumn("MEDICO");
        contenidoTabla.addColumn("FECHA INICIAL");
        contenidoTabla.addColumn("FECHA FINAL");

        Entidad entidad = new Recurso();
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
            Object[] row = new Object[8];     //creo un objeto fila con 6 columas/campos
            row[0] = ((Recurso) entidad1).getId_recurso();
            row[1] = ((Recurso) entidad1).getDia();
            row[2] = ((Recurso) entidad1).getId_consultorio();
            row[3] = ((Recurso) entidad1).getConsultorio();
            row[4] = ((Recurso) entidad1).getId_medico();
            row[5] = ((Recurso) entidad1).getMedico();
            row[6] = ((Recurso) entidad1).getFecha_inicial();
            row[7] = ((Recurso) entidad1).getFecha_final();

            contenidoTabla.addRow(row);
        }
        panelListado.add(scrollPane,BorderLayout.CENTER);
    }

    public void formularioRecurso(){
        JLabel jLabelId, jLabelDia, jLabelIdConsultorio, jLabelConsultorio,
                jLabelIdMedico, jLabelMedico, jLabelFechaInicial, jLabelFechaFinal;


        jLabelId = new JLabel("ID:");
        jLabelDia = new JLabel("DIA");
        jLabelIdConsultorio = new JLabel("ID CONSULTORIO:");
        jLabelConsultorio = new JLabel("CONSULTORIO:");
        jLabelIdMedico = new JLabel("ID MEDICO:");
        jLabelMedico = new JLabel("MEDICO:");
        jLabelFechaInicial = new JLabel("FECHA INICIAL:");
        jLabelFechaFinal = new JLabel("FECHA FINAL:");

        jTextFieldIdRecurso = new JTextField(10);
        jTextFieldIdRecurso.setEnabled(false);
        jTextFieldDia = new JTextField(20);
        jTextFieldIdConsultorio = new JTextField(20);
        jTextFieldConsultorio = new JTextField(20);
        jTextFieldIdMedico = new JTextField(20);
        jTextFieldMedico = new JTextField(20);
        jTextFieldFechaInicial = new JTextField(20);
        jTextFieldFechaFinal = new JTextField(20);

        panelFormulario = new JPanel();
        panelFormulario.setLayout(new BorderLayout());

        JPanel panelComponentes = new JPanel();
        panelComponentes.setLayout(new GridLayout(8,2));

        panelComponentes.add(jLabelId);
        panelComponentes.add(jTextFieldIdRecurso);
        panelComponentes.add(jLabelDia);
        panelComponentes.add(jTextFieldDia);
        panelComponentes.add(jLabelIdConsultorio);
        panelComponentes.add(jTextFieldIdConsultorio);
        panelComponentes.add(jLabelConsultorio);
        panelComponentes.add(jTextFieldConsultorio);
        panelComponentes.add(jLabelIdMedico);
        panelComponentes.add(jTextFieldIdMedico);
        panelComponentes.add(jLabelMedico);
        panelComponentes.add(jTextFieldMedico);
        panelComponentes.add(jLabelFechaInicial);
        panelComponentes.add(jTextFieldFechaInicial);
        panelComponentes.add(jLabelFechaFinal);
        panelComponentes.add(jTextFieldFechaFinal);

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


    public void guardarRecurso(){

        Entidad entidad3 = new Recurso();
        int dia = Integer.parseInt(jTextFieldDia.getText());
        int idconsultorio = Integer.parseInt(jTextFieldIdConsultorio.getText());
        int idrecurso = Integer.parseInt(String.valueOf(dia) + String.valueOf(idconsultorio));

        ((Recurso) entidad3).setId_recurso(idrecurso);
        ((Recurso) entidad3).setDia(dia);
        ((Recurso) entidad3).setId_consultorio(idconsultorio);
        ((Recurso) entidad3).setConsultorio(jTextFieldConsultorio.getText());
        ((Recurso) entidad3).setId_medico(Integer.parseInt(jTextFieldIdMedico.getText()));
        ((Recurso) entidad3).setMedico(jTextFieldMedico.getText());
        ((Recurso) entidad3).setFecha_inicial(LocalDate.parse(jTextFieldFechaInicial.getText()));
        ((Recurso) entidad3).setFecha_final(LocalDate.parse(jTextFieldFechaFinal.getText()));

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
            Entidad entidad2 = new Recurso();
            EntidadService entidadService2 = new EntidadService(entidad2);
            int idEliminar = (int) jTable.getValueAt(jTable.getSelectedRow(), 0);
            try {
                entidadService2.eliminar(idEliminar);
                this.remove(panelListado);
                listadoRecursos();
                this.add(panelListado, BorderLayout.CENTER);
                this.validate();
                this.repaint();

            } catch (ServiceException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Ha sucedido un error al eliminar un recurso "
                        + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }


        }
        if (e.getSource() == jButtonNuevo) {
            System.out.println("NUEVO");
            jButtonNuevo.setEnabled(false);
            jButtonModificar.setEnabled(false);
            jButtonEliminar.setEnabled(false);
            formularioRecurso();
            panelListado.add(panelFormulario,BorderLayout.EAST);
            this.validate();
            this.repaint();

        }

        if (e.getSource() == jButtonModificar) {
            System.out.println("MODIFICAR");
        }

        if (e.getSource() == jButtonGuardar) {
            System.out.println("GUARDAR");
            guardarRecurso();
            this.remove(panelListado);
            listadoRecursos();
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
            listadoRecursos();
            this.add(panelListado, BorderLayout.CENTER);
            jButtonNuevo.setEnabled(true);
            jButtonModificar.setEnabled(true);
            jButtonEliminar.setEnabled(true);
            this.validate();
            this.repaint();
        }
    }
}
