/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Manuel
 */
public class CodificacionFichero {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            InputStreamReader in = new InputStreamReader(new FileInputStream("prueba1.txt"));
            System.out.println("Codificación: "+ in.getEncoding());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CodificacionFichero.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}
