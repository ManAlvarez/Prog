/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/**
 *
 * @author Manuel
 */
public class EscribirFichero {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            PrintWriter out = new PrintWriter(new FileWriter("prueba1.txt", true));
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            String s;
            while (!(s = in.readLine()).equalsIgnoreCase("Salir")) {
                out.println(s);
            }
            out.close();
            in.close();
            BufferedReader in2 = new BufferedReader(new FileReader("prueba1.txt"));
            BufferedWriter out2 = new BufferedWriter(new FileWriter("prueba2.txt"));
            int n;
            while((n = in2.read())>0){
                out2.write(n);
            }
            in2.close();
            out2.close();

        } catch (IOException e) {
        }
    }

}
