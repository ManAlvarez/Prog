/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;


import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Manuel
 */
public class Paneles extends JFrame {

    JPanel panel1;
    JToggleButton boton;
    JCheckBox casillaDeVerificacion;
    ButtonGroup grupoBotones;
    JRadioButton boton1;
    JRadioButton boton2;

    public Paneles() {
        grupoBotones = new ButtonGroup();
        boton1 = new JRadioButton("si");
        boton2 = new JRadioButton("no");
        grupoBotones.add(boton1);
        grupoBotones.add(boton2);
        
        boton = new JToggleButton("pulsar");
        casillaDeVerificacion = new JCheckBox("marcar");
        panel1 = new JPanel();
        panel1.setBorder(new TitledBorder("Ejemplo"));
        setContentPane(panel1);
        panel1.add(boton,SwingConstants.CENTER);
        panel1.add(casillaDeVerificacion);
        panel1.add(boton1);
        panel1.add(boton2);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Paneles paneles = new Paneles();
        paneles.setDefaultCloseOperation(EXIT_ON_CLOSE);
        paneles.setSize(200,200);
        paneles.setLocationRelativeTo(null);
        paneles.setVisible(true);
    }

}
