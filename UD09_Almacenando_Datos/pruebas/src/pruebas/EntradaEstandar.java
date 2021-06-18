/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import java.io.IOException;

/**
 *
 * @author Manuel
 */
public class EntradaEstandar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            // Creamos un array de byte.
            byte[] data = new byte[2048];
            System.out.println("Ingrese algunos caracteres.");
            // Leer entrada estandar.
            System.in.read(data);
            System.out.println("Usted Ingreso: ");
            // Mostrar salida estandar.
            System.out.write(data);
        } catch (IOException e) {
        }

    }

}
