
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
public class Palindromos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String cadena, cadenaRevertida, cadenaComp, cadenaSinEspacios;
        int longitudCadena;
        Scanner sc = new Scanner(System.in);
        while(true){
            cadenaRevertida = "";
            cadena = sc.nextLine();
            if(cadena.equalsIgnoreCase("xxx"))break;
            cadenaSinEspacios = cadena.replace(" ","");
            longitudCadena = cadenaSinEspacios.length();
            for(int i = longitudCadena-1; i>= longitudCadena/2; i-- ){
                cadenaRevertida+= cadenaSinEspacios.charAt(i);
            }
            cadenaComp = cadenaSinEspacios.substring(0, longitudCadena/2+1);
            if(cadenaRevertida.equalsIgnoreCase(cadenaComp))System.out.println("SI");
            else System.out.println("NO");
        }  
    }
    
}
