/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Manuel
 */
public class CopiaDeFicheros {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            InputStream flujoEntrada = new FileInputStream("Captura.PNG");
            OutputStream flujoSalida = new FileOutputStream("Captura1.PNG");
            BufferedInputStream bufferEntrada = new BufferedInputStream(flujoEntrada);
            BufferedOutputStream bufferSalida = new BufferedOutputStream(flujoSalida);
            byte[] buffer = new byte[256];
            int n;
            while((n = bufferEntrada.read(buffer))>0){
                bufferSalida.write(buffer,0,n);
            }
            bufferEntrada.close();
            bufferSalida.close();  
            flujoEntrada.close();
            flujoSalida.close();                               
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CopiaDeFicheros.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CopiaDeFicheros.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
