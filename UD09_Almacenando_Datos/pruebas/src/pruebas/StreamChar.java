/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Manuel
 */
public class StreamChar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            PrintWriter out = new PrintWriter(new FileWriter("streamcharOut.txt",true));
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String linea;
            while(!(linea = br.readLine()).equalsIgnoreCase("Salir")){
                out.println(linea);
            }
            out.close();
            br.close();
            
        } catch (IOException ex) {
            Logger.getLogger(StreamChar.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
