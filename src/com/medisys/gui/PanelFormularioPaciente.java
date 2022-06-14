package com.medisys.gui;

import com.medisys.entidades.Paciente;
import com.medisys.service.PacienteService;
import com.medisys.service.ServiceException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelFormularioPaciente extends JPanel{

    //componentes
    private JPanel panelComponentes;
    JLabel jlabelId;
    JLabel jlabelNombre;
    JLabel jlabelApellido;
    JLabel jlabelEmail;
    JLabel jlabelClave;
    JLabel jlabelDni;
    JLabel jlabelIdObraSocial;
    JLabel jlabelObraSocial;
    JLabel jlabelNroAfiliado;
    JLabel jlabelEstado;

    JTextField jTextFieldId;
    JTextField jTextFieldNombre;
    JTextField jTextFieldApellido;
    JTextField jTextFieldEmail;
    JPasswordField jPasswordFieldClave;
    JTextField jTextFieldDni;
    JTextField jTextFieldIdObraSocial;
    JTextField jTextFieldObraSocial;
    JTextField jTextFieldNroAfiliado;
    JTextField jTextFieldEstado;

    //Componentes de la botonera
    private JPanel panelBotonera;
    JButton jButtonGuardar;
    JButton jButtonCancelar;

    private boolean modificacion;

    //Cada panel conoce al panel manager
    PanelManager panelManager;

    //Hacemos un armarPanelFormularioPaciente que reciba un estudiante
    //para permitir llenar todos los componentes con los datos de un estudiante
    // para poder modificarlo
    public void armarPanelFormularioPaciente(Paciente paciente){

        jTextFieldId.setText(String.valueOf(paciente.getId_paciente()));
        jTextFieldNombre.setText(paciente.getNombre());
        jTextFieldApellido.setText(paciente.getApellido());
        jTextFieldEmail.setText(paciente.getEmail());
        jPasswordFieldClave.setText(paciente.getClave());
        jTextFieldDni.setText(String.valueOf(paciente.getDni()));
        jTextFieldIdObraSocial.setText(String.valueOf(paciente.getId_obra_social()));
        jTextFieldObraSocial.setText(paciente.getObra_social());
        jTextFieldNroAfiliado.setText(String.valueOf(paciente.getNro_afiliado()));
        jTextFieldEstado.setText(String.valueOf(paciente.isEstado()));
        modificacion = true;
    }

    public void vaciarComponentes(){
        jTextFieldId.setText("");
        jTextFieldNombre.setText("");
        jTextFieldApellido.setText("");
        jTextFieldEmail.setText("");
        jPasswordFieldClave.setText("");
        jTextFieldDni.setText("");
        jTextFieldIdObraSocial.setText("");
        jTextFieldObraSocial.setText("");
        jTextFieldNroAfiliado.setText("");
        jTextFieldEstado.setText("");
        modificacion = false;
    }
    public void armarPanelFormularioPaciente(PanelManager panelManager){
        this.panelManager = panelManager;

        jlabelId = new JLabel("ID:");
        jlabelNombre = new JLabel("NOMBRE:");
        jlabelApellido = new JLabel("APELLIDO:");
        jlabelEmail = new JLabel("EMAIL:");
        jlabelClave = new JLabel("CLAVE:");
        jlabelDni = new JLabel("DNI:");
        jlabelIdObraSocial = new JLabel("ID OBRA SOCIAL:");
        jlabelObraSocial = new JLabel("OBRA SOCIAL:");
        jlabelNroAfiliado = new JLabel("NRO AFILIADO:");
        jlabelEstado = new JLabel("ESTADO:");

        jTextFieldId = new JTextField(10);
        jTextFieldNombre = new JTextField(40);
        jTextFieldApellido = new JTextField(40);
        jTextFieldEmail = new JTextField(40);
        jPasswordFieldClave = new JPasswordField(40);
        jTextFieldDni = new JTextField(40);
        jTextFieldIdObraSocial = new JTextField(40);
        jTextFieldObraSocial = new JTextField(40);
        jTextFieldNroAfiliado = new JTextField(40);
        jTextFieldEstado = new JTextField(40);

        panelComponentes = new JPanel();
        panelComponentes.setLayout(new GridLayout(10,2));
        panelComponentes.add(jlabelId);
        panelComponentes.add(jTextFieldId);
        panelComponentes.add(jlabelNombre);
        panelComponentes.add(jTextFieldNombre);
        panelComponentes.add(jlabelApellido);
        panelComponentes.add(jTextFieldApellido);
        panelComponentes.add(jlabelEmail);
        panelComponentes.add(jTextFieldEmail);
        panelComponentes.add(jlabelClave);
        panelComponentes.add(jPasswordFieldClave);
        panelComponentes.add(jlabelDni);
        panelComponentes.add(jTextFieldDni);
        panelComponentes.add(jlabelIdObraSocial);
        panelComponentes.add(jTextFieldIdObraSocial);
        panelComponentes.add(jlabelObraSocial);
        panelComponentes.add(jTextFieldObraSocial);
        panelComponentes.add(jlabelNroAfiliado);
        panelComponentes.add(jTextFieldNroAfiliado);
        panelComponentes.add(jlabelEstado);
        panelComponentes.add(jTextFieldEstado);

        this.setLayout(new BorderLayout());//el this no hace falta, es el panel principal
        this.add(panelComponentes,BorderLayout.CENTER);

        panelBotonera = new JPanel();
        jButtonGuardar = new JButton("GUARDAR");
        jButtonCancelar = new JButton("CANCELAR");

        panelBotonera.add(jButtonGuardar);
        panelBotonera.add(jButtonCancelar);
        add(panelBotonera, BorderLayout.SOUTH);

        //Guardamos un paciente
        jButtonGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Paciente paciente = new Paciente();
                paciente.setId_paciente(Integer.parseInt(jTextFieldId.getText()));
                paciente.setNombre(jTextFieldNombre.getText());
                paciente.setApellido(jTextFieldApellido.getText());
                paciente.setEmail(jTextFieldEmail.getText());
                paciente.setClave(jPasswordFieldClave.getText());
                paciente.setDni(Integer.parseInt(jTextFieldDni.getText()));
                paciente.setId_obra_social(Integer.parseInt(jTextFieldIdObraSocial.getText()));
                paciente.setObra_social(jTextFieldObraSocial.getText());
                paciente.setNro_afiliado(Integer.parseInt(jTextFieldNroAfiliado.getText()));
                paciente.setEstado(Boolean.parseBoolean(jTextFieldEstado.getText()));

                PacienteService pacienteService = new PacienteService();
                try {
                    System.out.println(modificacion);
                    if(modificacion)
                        pacienteService.modificarPaciente(paciente);
                    else
                        pacienteService.guardarPaciente(paciente);
                } catch (ServiceException serviceException) {
                    //Dialog
                    JOptionPane.showMessageDialog(null,"Ha sucedido un error al " +
                            "guardar o modificar un paciente. Por favor, contactar al administrador: "
                            + serviceException.getMessage(), "Error",JOptionPane.ERROR_MESSAGE);
                }

                panelManager.mostrarListaPacientes();
            }
        });

        //Al cancelar, cerramos el frame donde esta el panel
        jButtonCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vaciarComponentes();
                panelManager.mostrarListaPacientes();
            }
        });



    }

}
