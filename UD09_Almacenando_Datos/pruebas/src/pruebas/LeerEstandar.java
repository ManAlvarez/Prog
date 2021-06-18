/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Manuel
 */
public class LeerEstandar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        StringBuilder sb = new StringBuilder();
        char c;
        try {
            while ((c = (char) System.in.read()) != '\n') {
                sb.append(c);
            }
            System.out.print(sb);
        } catch (IOException ex) {
            Logger.getLogger(LeerEstandar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
