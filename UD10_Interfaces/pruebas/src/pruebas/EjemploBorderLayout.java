package pruebas;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Manuel
 */
public class EjemploBorderLayout extends JFrame implements ActionListener{

    JButton boton1, boton2, boton3, boton4, boton5;
    BorderLayout miBorderLayout;
    
    public EjemploBorderLayout() {
    
        //Creamos nuestro layout.
        miBorderLayout = new BorderLayout(3, 3);
        
        //Usamos el layout.
        setLayout(miBorderLayout);
        
        //Creamos los botones.
        boton1 = new JButton("Botón 1");
        boton2 = new JButton("Botón 2");
        boton3 = new JButton("Botón 3");
        boton4 = new JButton("Botón 4");
        boton5 = new JButton("Botón 5");
        
        //Añadir los botones a la posición deseada.
        add(boton1,BorderLayout.SOUTH);
        add(boton2,BorderLayout.WEST);
        add(boton3,BorderLayout.NORTH);
        add(boton4,BorderLayout.EAST);
        add(boton5,BorderLayout.CENTER);
        
        //Añadir el oyente a los botones.
        boton1.addActionListener(this);
        boton2.addActionListener(this);
        boton3.addActionListener(this);
        boton4.addActionListener(this);
        boton5.addActionListener(this);
    }
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        EjemploBorderLayout formulario = new EjemploBorderLayout();
        formulario.setTitle("Ejemplo de BorderLayout");
        formulario.setSize(400, 400);
        formulario.setLocationRelativeTo(null);
        formulario.setDefaultCloseOperation(EXIT_ON_CLOSE);
        formulario.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        miBorderLayout.setHgap(miBorderLayout.getHgap()+5);
        miBorderLayout.setVgap(miBorderLayout.getVgap()+5);
        setLayout(miBorderLayout);
        validate();
    }
    
}
