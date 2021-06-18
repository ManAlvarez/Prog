/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

/**
 *
 * @author Manuel
 */
public class Menus extends JFrame{

    public Menus() {
        JMenuBar barra = new JMenuBar();
        JMenu menu = new JMenu("Archivo");
        JMenuItem item1 = new JMenuItem("Abrir");
        JMenuItem item3 = new JMenuItem("Guardar");
        JMenuItem item2 = new JMenuItem("Cerrar");
        menu.add(item1);
        menu.add(item3);
        menu.add(new JPopupMenu.Separator());
        menu.add(item2);
        setJMenuBar(barra);
        barra.add(menu);      
    }
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Menus menu = new Menus();
        menu.setTitle("Menus");
        menu.setSize(200,200);
        menu.setLocationRelativeTo(null);
        menu.setDefaultCloseOperation(EXIT_ON_CLOSE);
        menu.setVisible(true);
    }
    
}
