/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Manuel
 */
public class Teclas extends JFrame {
    
    JPanel panel;
    JLabel etiqueta;

    // Creamos los componentes.
    public Teclas() {
        // Creamos los componentes.
        panel = new JPanel();
        etiqueta = new JLabel();

        // Añadimos el componente al panel.
        panel.add(etiqueta);

        // Añadimos el panel a la ventana.
        getContentPane().add(panel);
        OyenteTeclas oyenteTeclas = new OyenteTeclas();
        this.addKeyListener(oyenteTeclas);
        
    }
    
    class OyenteTeclas implements KeyListener {
        
        @Override
        public void keyTyped(KeyEvent e) {
            etiqueta.setText("Se ha pulsado y soltado la tecla " + e.getKeyChar());
        }
        
        @Override
        public void keyPressed(KeyEvent e) {
            etiqueta.setText("Se ha presionado la tecla "+e.getKeyChar());
        }
        
        @Override
        public void keyReleased(KeyEvent e) {
            etiqueta.setText("Se ha soltado la tecla "+e.getKeyChar());
        }
    }
    
    public static void main(String[] args){
        Teclas teclas = new Teclas();
        teclas.setTitle("Teclas");
        teclas.setSize(200,200);
        teclas.setVisible(true);
    }
    
}
