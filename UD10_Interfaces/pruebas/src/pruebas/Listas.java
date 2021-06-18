/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import javax.swing.JFrame;
import javax.swing.JList;

/**
 *
 * @author Manuel
 */
public class Listas extends JFrame {

    public Listas() {
        String[] info = {"Pato", "Loro", "Perro", "Cuervo"};

        JList listaDatos = new JList(info);

        
        for (int i = 0; i < listaDatos.getModel().getSize(); i++) {
            System.out.println(listaDatos.getModel().getElementAt(i));
        }
    }
        /**
         * @param args the command line arguments
         */
        
    public static void main(String[] args) {
        // TODO code application logic here
        new Listas();
    }

}
