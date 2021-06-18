/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Manuel
 */
public class EjemploCardLayout extends JFrame{

    CardLayout tarjetas;
    JPanel panelTarjetas;

    public EjemploCardLayout() {
    
        //Centro el JFrame.
        setLocationRelativeTo(null);
        
        //Inicio un bordel layout para el JFrame.
        setLayout(new BorderLayout());
        
        //Creo un panel para el botón superior con fondo rojo.
        JPanel panelSuperior = new JPanel();
        panelSuperior.setBackground(Color.red);
        
        //Añadir botón para cambiar tarjetas y añadir ActionListener.
        JButton cambiarTarjeta = new JButton("Cambiar Tarjeta");
        cambiarTarjeta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tarjetas.next(panelTarjetas);
            }
        });
        
        // Añado el botón al panel de las pestañas.
        panelSuperior.add(cambiarTarjeta);
        
        // Añado el panel superior en la parte superior del JFrame.
        add(panelSuperior,BorderLayout.PAGE_START);
        
        // Inicializo el layout y el panel para las tarjetas.      
        tarjetas = new CardLayout();
        panelTarjetas = new JPanel();
        panelTarjetas.setLayout(tarjetas);
        
        // Inicializo 2 tarjetas, cada una es un JPanel con un color diferente.
        JPanel primeraTarjeta = new JPanel();
        JPanel segundaTarjeta = new JPanel();
        primeraTarjeta.setBackground(Color.green);
        segundaTarjeta.setBackground(Color.blue);
        
        // Añado botones a las tarjetas.
        nuevoBoton(primeraTarjeta, "Manzanas");
        nuevoBoton(primeraTarjeta, "Naranjas");
        nuevoBoton(primeraTarjeta, "Plátanos");
        nuevoBoton(segundaTarjeta, "Lechugas");
        nuevoBoton(segundaTarjeta, "Tomates");
        nuevoBoton(segundaTarjeta, "Cebollas");
        
        // Añado las dos tarjetas al panel de tarjetas.
        panelTarjetas.add(primeraTarjeta);
        panelTarjetas.add(segundaTarjeta);
        
        // Muestro la primera
        tarjetas.show(panelTarjetas, "Frutas");
        
        // Añado el panel de tarjetas al centro del border layout.
        add(panelTarjetas, BorderLayout.CENTER);
               
    }
    
    //Nuevo botón
    private void nuevoBoton(JPanel panel, String titulo){
        JButton boton = new JButton(titulo);
        panel.add(boton);
    }
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        EjemploCardLayout formulario = new EjemploCardLayout();
        formulario.setSize(400, 400);
        formulario.setTitle("Ejemplo de CardLayout");
        formulario.setDefaultCloseOperation(EXIT_ON_CLOSE);
        formulario.setVisible(true);
    }
    
}
