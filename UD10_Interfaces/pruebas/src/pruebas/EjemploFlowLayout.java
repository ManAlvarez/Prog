/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.sound.midi.MidiFileFormat;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author Manuel
 */
public class EjemploFlowLayout extends JFrame implements ActionListener {

    JButton boton1, boton2, boton3, boton4, boton5;
    FlowLayout miFlowLayout;

    public EjemploFlowLayout() {
        // Instancia a un objeto FlowLayout alineando el centro y con una separacion de 3px en horizontal y vertical.
        miFlowLayout = new FlowLayout(FlowLayout.CENTER, 3, 3);

        // Uso este FlowLayout para que sea el controlador de posicionamiento de mi objeto JFrame.
        setLayout(miFlowLayout);

        // Creo los 5 botones,
        boton1 = new JButton("Botón 1");
        boton2 = new JButton("Botón 2");
        boton3 = new JButton("Botón 3");
        boton4 = new JButton("Botón 4");
        boton5 = new JButton("Botón 5");
        
        // Añado los botones a JFrame.
        add(boton1);
        add(boton2);
        add(boton3);
        add(boton4);
        add(boton5);
        
        // Añado el oyente a los botones.
        boton1.addActionListener(this);
        boton2.addActionListener(this);
        boton3.addActionListener(this);
        boton4.addActionListener(this);
        boton5.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Al hacer clic en un botón, añado 5px de espacio horizontal y vertical entre botones.
        miFlowLayout.setHgap(miFlowLayout.getHgap()+5);
        miFlowLayout.setVgap(miFlowLayout.getVgap()+5);
        // Fijo el nuevo layout al formulario.
        setLayout(miFlowLayout);
        // Valido el formulario para asegurarme de que se actualiza en pantalla.
        validate();
    }
    
    public static void main(String[] args){
        // Creo un formulario
        EjemploFlowLayout formulario = new EjemploFlowLayout();
        // Le doy tamaño.
        formulario.setSize(400,400);
        // Le añado un título.
        formulario.setTitle("Ejemplo de FlowLayout");
        // Configuro el cierre por defecto de la ventana.
        formulario.setDefaultCloseOperation(EXIT_ON_CLOSE);
        // Hago visible el formulario.
        formulario.setVisible(true);
    }

}
