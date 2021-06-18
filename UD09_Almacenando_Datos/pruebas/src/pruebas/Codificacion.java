/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Manuel
 */
public class Codificacion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            FileInputStream fis = new FileInputStream("prueba.dat");
            InputStreamReader isr = new InputStreamReader(fis);
            System.out.println(isr.getEncoding());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Codificacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}
