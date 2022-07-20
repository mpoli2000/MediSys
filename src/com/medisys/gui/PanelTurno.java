package com.medisys.gui;

import com.medisys.entidades.Entidad;
import com.medisys.entidades.Recurso;
import com.medisys.entidades.Turno;
import com.medisys.service.EntidadService;
import com.medisys.service.ServiceException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;


public class PanelTurno extends JPanel implements ActionListener {
    JLabel jLabel;
    JButton jButtonNuevo, jButtonModificar, jButtonEliminar;

    JPanel panelBotonera, panelBotones;
    JPanel panelListado,panelFormulario;

    JTable jTable;
    DefaultTableModel contenidoTabla;
    JScrollPane scrollPane;

    JTextField jTextFieldIdTurno, jTextFieldFechaTurno, jTextFieldIdConsultorio, jTextFieldConsultorio,
            jTextFieldIdMedico, jTextFieldMedico, jTextFieldOsMedico, jTextFieldIdPaciente, jTextFieldPaciente,
            jTextFieldOsPaciente, jTextFieldHonorario, jTextFieldDescuento, jTextFieldSaldo;
    JButton jButtonGuardar, jButtonCancelar;

    PanelTurno(){

        jLabel = new JLabel();
        jLabel.setFont(new Font("Helbetica",Font.PLAIN,18));
        jLabel.setText("TURNOS");

        listadoTurnos();

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

    public void listadoTurnos(){

        panelListado = new JPanel();
        panelListado.setLayout(new BorderLayout());

        contenidoTabla = new DefaultTableModel();
        jTable = new JTable(contenidoTabla);
        scrollPane = new JScrollPane();
        scrollPane.setViewportView(jTable);   // un scrollpane contiene una tabla y la tabla tiene un contenido

        contenidoTabla.addColumn("ID TURNO");
        contenidoTabla.addColumn("FECHA TURNO");
        contenidoTabla.addColumn("ID CONSULTORIO");
        contenidoTabla.addColumn("CONSULTORIO");
        contenidoTabla.addColumn("ID MEDICO");
        contenidoTabla.addColumn("MEDICO");
        contenidoTabla.addColumn("OS MEDICO");
        contenidoTabla.addColumn("ID PACIENTE");
        contenidoTabla.addColumn("PACIENTE");
        contenidoTabla.addColumn("OS PACIENTE");
        contenidoTabla.addColumn("HONORARIO");
        contenidoTabla.addColumn("DESCUENTO");
        contenidoTabla.addColumn("SALDO");


        Entidad entidad = new Turno();
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
            Object[] row = new Object[13];     //creo un objeto fila con columas/campos
            row[0] = ((Turno) entidad1).getId_turno();
            row[1] = ((Turno) entidad1).getFecha_turno();
            row[2] = ((Turno) entidad1).getId_consultorio();
            row[3] = ((Turno) entidad1).getConsultorio();
            row[4] = ((Turno) entidad1).getId_medico();
            row[5] = ((Turno) entidad1).getMedico();
            row[6] = ((Turno) entidad1).getOs_medico();
            row[7] = ((Turno) entidad1).getId_paciente();
            row[8] = ((Turno) entidad1).getPaciente();
            row[9] = ((Turno) entidad1).getOs_paciente();
            row[10] = ((Turno) entidad1).getHonorario();
            row[11] = ((Turno) entidad1).getDescuento();
            row[12] = ((Turno) entidad1).getSaldo();

            contenidoTabla.addRow(row);
        }
        panelListado.add(scrollPane,BorderLayout.CENTER);
    }

    public void formularioTurno(){
        JLabel jLabelId, jLabelFechaTurno, jLabelIdConsultorio, jLabelConsultorio,
                jLabelIdMedico, jLabelMedico, jLabelOsMedico, jLabelIdPaciente, jLabelPaciente,
                jLabelOsPaciente, jLabelHonorarios, jLabelDescuento, jLabelSaldo;


        jLabelId = new JLabel("ID:");
        jLabelFechaTurno = new JLabel("FECHA TURNO:");
        jLabelIdConsultorio = new JLabel("ID CONSULTORIO:");
        jLabelConsultorio = new JLabel("CONSULTORIO:");
        jLabelIdMedico = new JLabel("ID MEDICO:");
        jLabelMedico = new JLabel("MEDICO:");
        jLabelOsMedico = new JLabel("OS MEDICO:");
        jLabelIdPaciente = new JLabel("ID PACIENTE:");
        jLabelPaciente = new JLabel("PACIENTE:");
        jLabelOsPaciente = new JLabel("OS PACIENTE:");
        jLabelHonorarios = new JLabel("HONORARIOS:");
        jLabelDescuento = new JLabel("DESCUENTO:");
        jLabelSaldo = new JLabel("SALDO:");

        jTextFieldIdTurno = new JTextField(10);
        jTextFieldFechaTurno = new JTextField(20);
        jTextFieldIdConsultorio = new JTextField(20);
        jTextFieldConsultorio = new JTextField(20);
        jTextFieldIdMedico = new JTextField(20);
        jTextFieldMedico = new JTextField(20);
        jTextFieldOsMedico = new JTextField(20);
        jTextFieldIdPaciente = new JTextField(20);
        jTextFieldPaciente = new JTextField(20);
        jTextFieldOsPaciente = new JTextField(20);
        jTextFieldHonorario = new JTextField(20);
        jTextFieldDescuento = new JTextField(20);
        jTextFieldSaldo = new JTextField(20);


        panelFormulario = new JPanel();
        panelFormulario.setLayout(new BorderLayout());

        JPanel panelComponentes = new JPanel();
        panelComponentes.setLayout(new GridLayout(13,2));

        panelComponentes.add(jLabelId);
        panelComponentes.add(jTextFieldIdTurno);
        panelComponentes.add(jLabelFechaTurno);
        panelComponentes.add(jTextFieldFechaTurno);
        panelComponentes.add(jLabelIdConsultorio);
        panelComponentes.add(jTextFieldIdConsultorio);
        panelComponentes.add(jLabelConsultorio);
        panelComponentes.add(jTextFieldConsultorio);
        panelComponentes.add(jLabelIdMedico);
        panelComponentes.add(jTextFieldIdMedico);
        panelComponentes.add(jLabelMedico);
        panelComponentes.add(jTextFieldMedico);
        panelComponentes.add(jLabelOsMedico);
        panelComponentes.add(jTextFieldOsMedico);
        panelComponentes.add(jLabelIdPaciente);
        panelComponentes.add(jTextFieldIdPaciente);
        panelComponentes.add(jLabelPaciente);
        panelComponentes.add(jTextFieldPaciente);
        panelComponentes.add(jLabelOsPaciente);
        panelComponentes.add(jTextFieldOsPaciente);
        panelComponentes.add(jLabelHonorarios);
        panelComponentes.add(jTextFieldHonorario);
        panelComponentes.add(jLabelDescuento);
        panelComponentes.add(jTextFieldDescuento);
        panelComponentes.add(jLabelSaldo);
        panelComponentes.add(jTextFieldSaldo);


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


    public void guardarTurno(){

        Entidad entidad3 = new Turno();

        ((Turno) entidad3).setId_turno(Integer.parseInt(jTextFieldIdTurno.getText()));
        ((Turno) entidad3).setFecha_turno(LocalDateTime.parse(jTextFieldFechaTurno.getText()));
        ((Turno) entidad3).setId_consultorio(Integer.parseInt(jTextFieldIdConsultorio.getText()));
        ((Turno) entidad3).setConsultorio(jTextFieldConsultorio.getText());
        ((Turno) entidad3).setId_medico(Integer.parseInt(jTextFieldIdMedico.getText()));
        ((Turno) entidad3).setMedico(jTextFieldMedico.getText());
        ((Turno) entidad3).setOs_medico(jTextFieldOsMedico.getText());
        ((Turno) entidad3).setId_paciente(Integer.parseInt(jTextFieldIdPaciente.getText()));
        ((Turno) entidad3).setPaciente(jTextFieldPaciente.getText());
        ((Turno) entidad3).setOs_paciente(jTextFieldOsPaciente.getText());
        ((Turno) entidad3).setHonorario(Integer.parseInt(jTextFieldHonorario.getText()));
        ((Turno) entidad3).setDescuento(Float.parseFloat(jTextFieldDescuento.getText()));
        ((Turno) entidad3).setSaldo(Float.parseFloat(jTextFieldSaldo.getText()));


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
            Entidad entidad2 = new Turno();
            EntidadService entidadService2 = new EntidadService(entidad2);
            int idEliminar = (int) jTable.getValueAt(jTable.getSelectedRow(), 0);
            try {
                entidadService2.eliminar(idEliminar);
                this.remove(panelListado);
                listadoTurnos();
                this.add(panelListado, BorderLayout.CENTER);
                this.validate();
                this.repaint();

            } catch (ServiceException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Ha sucedido un error al eliminar un turno "
                        + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }


        }
        if (e.getSource() == jButtonNuevo) {
            System.out.println("NUEVO");
            jButtonNuevo.setEnabled(false);
            jButtonModificar.setEnabled(false);
            jButtonEliminar.setEnabled(false);
            formularioTurno();
            panelListado.add(panelFormulario,BorderLayout.EAST);
            this.validate();
            this.repaint();

        }

        if (e.getSource() == jButtonModificar) {
            System.out.println("MODIFICAR");
        }

        if (e.getSource() == jButtonGuardar) {
            System.out.println("GUARDAR");
            guardarTurno();
            this.remove(panelListado);
            listadoTurnos();
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
            listadoTurnos();
            this.add(panelListado, BorderLayout.CENTER);
            jButtonNuevo.setEnabled(true);
            jButtonModificar.setEnabled(true);
            jButtonEliminar.setEnabled(true);
            this.validate();
            this.repaint();
        }
    }
}
