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
public class CopiarArchivo {
    
    public static void main(String[] args){
        
        try {
            InputStream is = new FileInputStream("Captura.PNG");
            OutputStream os = new FileOutputStream("Copia.PNG");
            BufferedInputStream bfis = new BufferedInputStream(is);
            BufferedOutputStream bfos = new BufferedOutputStream(os);
            
            byte[] buffer = new byte[256];
            int n;
            while((n = bfis.read(buffer)) > 0){
                bfos.write(buffer, 0, n);
            }
            bfis.close();
            bfos.close();
            is.close();
            os.close();
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CopiarArchivo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CopiarArchivo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
