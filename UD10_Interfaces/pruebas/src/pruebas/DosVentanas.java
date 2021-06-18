/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Manuel
 */
public class DosVentanas {
    
    JFrame frame;
    JDialog dialog;
    JButton boton;
    JLabel etiqueta;
       
    public DosVentanas(){
        // Creamos las ventanas
        frame = new JFrame();
        dialog = new JDialog();
        boton = new JButton("Siguiente ventana");
        etiqueta = new JLabel("Hola");
        
        frame.add(boton);
        dialog.add(etiqueta);
        frame.pack();
        dialog.pack();
        
        // Creamos el oyente en el botón
        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                dialog.setVisible(true);
                dialog.setModal(true);
            }
        });
        
        dialog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                frame.setVisible(true);
                dialog.setVisible(false);
            }

            @Override
            public void windowClosing(WindowEvent e) {
                frame.setVisible(true);
                dialog.setVisible(false);
            }            
        });
        
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                System.exit(0);
            }

            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
            
        });
        
        // Mostramos el frame.
        frame.setTitle("Ventana Principal");
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
        dialog.setTitle("Ventana Secundaria");
        dialog.pack();
        dialog.setLocationRelativeTo(null);
    }
    
    public static void main(String[] args){
        new DosVentanas();
    }
    
}
