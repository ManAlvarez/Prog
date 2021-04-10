/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package token;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StreamTokenizer;


public class Token {

    public static void contarPalabrasyNumeros(String nombre_fichero) {

        StreamTokenizer sTokenizer = null;
        int contapal = 0, numNumeros = 0;

        try {

            sTokenizer = new StreamTokenizer(new FileReader(nombre_fichero));

            while (sTokenizer.nextToken() != StreamTokenizer.TT_EOF) {

                if (sTokenizer.ttype == StreamTokenizer.TT_WORD)
                    contapal++;
                else if (sTokenizer.ttype == StreamTokenizer.TT_NUMBER)
                    numNumeros++;
            }

            System.out.println("Número de palabras en el fichero: " + contapal);
            System.out.println("Número de números en el fichero: " + numNumeros);

        } catch (FileNotFoundException ex) {
           System.out.println(ex.getMessage()) ;
        } catch (IOException ex) {
           System.out.println(ex.getMessage()) ;
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        contarPalabrasyNumeros("c:\\datos.txt");
    }
}

