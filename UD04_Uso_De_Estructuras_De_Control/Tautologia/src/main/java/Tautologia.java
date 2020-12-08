
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Manuel
 */
public class Tautologia {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int nCasos;
        String cadena;
        String[] palabras;
        Scanner sc = new Scanner(System.in);
        nCasos = sc.nextInt();
        sc.nextLine();
        for(int i = 1; i<= nCasos; i++){
            cadena = sc.nextLine();
            palabras = cadena.split(" ");
            if(palabras[0].equalsIgnoreCase(palabras[2]))System.out.println("TAUTOLOGIA");
            else System.out.println("NO TAUTOLOGIA");
        }       
    }
    
}
