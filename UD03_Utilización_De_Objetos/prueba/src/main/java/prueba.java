
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
public class prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        esPalindromo("Amad a la dama");
    }
    
    public static boolean esPalindromo(String cadena){
        String c1 = "", c2 = "";
        String c = cadena.toLowerCase().replace(" ", "").
        replace("á", "a").replace("é", "e").replace("í", "i").replace("ó", "o").replace("ú", "u");
        for(int i = 0; i< c.length()/2; i++){
            c1 += c.charAt(i);
        }
        for(int i = c.length()-1; i>=c.length()/2+1; i--){
            c2 += c.charAt(i); 
        }
        if(c1.equals(c2)){
            return true;
        }else{
            return false;
        }
    }
    
}
