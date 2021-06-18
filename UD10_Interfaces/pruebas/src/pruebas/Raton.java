/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Manuel
 */
public class Raton extends JFrame {

    JPanel panel;
    JLabel etiqueta;

    public Raton() {
        // Creamos los componentes
        panel = new JPanel();
        etiqueta = new JLabel();
        
        // Añadimos el componente al panel.
        panel.add(etiqueta);
        
        // Añadimos el panel a la ventana.
        getContentPane().add(panel);
        
        // Se crea el objeto oyente.
        OyenteRaton oyenteRaton = new OyenteRaton();
        
        // Se añade el oyente al componente.
        this.addMouseListener(oyenteRaton);
                     
    }
    
    class OyenteRaton implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent e) {           
        }

        @Override
        public void mousePressed(MouseEvent e) {
            etiqueta.setText("Se ha pulsado un botón del ratón en un componente.");
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            etiqueta.setText("Se ha soltado un botón del ratón en un componente.");
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            etiqueta.setText("Se mueve el raton por un componente.");
        }

        @Override
        public void mouseExited(MouseEvent e) {
            etiqueta.setText("Se sale de un componente.");
        }
        
    }
    
    public static void main(String[] args){
        Raton raton = new Raton();
        raton.setTitle("Ratón");
        raton.setSize(200,200);
        raton.setVisible(true);
    }

}
