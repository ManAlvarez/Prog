/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Manuel
 */
public class Ventanilla extends JFrame {

    JLabel etiqueta;
    JButton botonUno, botonDos;
    JPanel panel;

    public Ventanilla() {
        // Creamos los componentes.
        etiqueta = new JLabel("La etiqueta es: ");
        botonUno = new JButton("Uno");
        botonDos = new JButton("Dos");
        panel = new JPanel();

        // Añadimos los componentes al panel.
        panel.add(etiqueta);
        panel.add(botonUno);
        panel.add(botonDos);

        // Añadir el panel al Frame.
        getContentPane().add(panel);
        // Crear objeto de la clase oyente para cuando se pulse el botón.
        OyenteAccion oyenteBoton = new OyenteAccion();
        // Registrar el objeto como oyente en los dos botones.
        botonUno.addActionListener(oyenteBoton);
        botonDos.addActionListener(oyenteBoton);
    }

    // Implementamos una clase oyente.
    class OyenteAccion implements ActionListener {
        // Cuando se pinche el botón.

        @Override
        public void actionPerformed(ActionEvent e) {
            // Obtener el botón que disparó el evento.
            JButton boton = (JButton) e.getSource();
            // Escribir en la etiqueta el botón que se pulsó.
            etiqueta.setText("Botón pulsado: " + boton.getText());
        }
    }

    public static void main(String args[]) {
        // Crear la ventana
        Ventanilla ventana = new Ventanilla();
        // Establecer el título, el tamaño y hacerla visible
        ventana.setTitle("Título de la ventana");
        ventana.setSize(350,80);
        ventana.setVisible(true);
    }
}
