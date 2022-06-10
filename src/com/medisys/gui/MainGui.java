package com.medisys.gui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainGui {
    public static void main(String[] args) {
        System.out.println("Interfaces Graficas");

        JFrame frame = new JFrame(); //defino un contenedor de tipo JFrame = ventana
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //cierra la ventana cdo aprieto x
        //no agregar contenido dentro del frame ni definir el layout

        //componentes
        JLabel jlabel = new JLabel();
        jlabel.setText("Nombre:");
        JTextField textField = new JTextField(20); //20 caracteres
        JButton jButton = new JButton("Guardar"); //boton de guardar
        JLabel jLabelRespuesta = new JLabel();

        JPanel panel = new JPanel(); //defino un contenedor de tipo JPanel que contenga los componentes
        //LayoutManager layout = new BorderLayout(); //border layout es un objeto de tipo LayoutManager
        panel.setLayout(new FlowLayout()); //layout by default
        //panel.setLayout(new BorderLayout());

        //definir un panel ppal con su layout y luego  los paneles dentro que se necesiten con sus componentes

        panel.add(jlabel);
        panel.add(textField);
        panel.add(jButton);
        panel.add(jLabelRespuesta);
        //panel.add(jlabel, BorderLayout.WEST);
        //panel.add(textField, BorderLayout.CENTER);
        //panel.add(jButton, BorderLayout.SOUTH);

        frame.getContentPane().add(panel);// lea agrego el panel con sus elementos al frame
        frame.pack(); //metodo pack, cdo se haga visible definir el tamaño para que se vean los componentes dentro
        frame.setVisible(true);

        ActionListener evento = new ClicBoton();
        jButton.addActionListener(evento);

        //Clases anonimas, no tienen nombre, se instancian e implenta la interface Action Listener,
        //no se rompe con el paradigma orientado a objetos para eventos,
        //no tengo que definir la clase para cada objeto,
        //dentro del metodo puedo ver todos los objetos / componentes
        //jButton.addActionListener(new clickBoton implements ActionListener)
        //java implemnto hacer un new de la interface, sin necesidad de crear la clase y definis el metodo directamente
        // solo necesito implementar un listener
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jLabelRespuesta.setText(textField.getText());
            }
        });



    }

}
