/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Manuel
 */
public class Palindromo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(esPalindromo("Amad a la dama"));
    }

    public static boolean esPalindromo(String cadena) {
        String cadenaAux = "";
        String cadenaInicio = "";
        String cadenaFinal = "";
        for (int i = 0; cadena.length() > i; i++) {
            if (Character.isLetter(cadena.charAt(i))) {
                cadenaAux += cadena.charAt(i);
            }
        }
        int longitud;
        longitud = cadenaAux.length();
        for (int i = 0; longitud / 2 > i; i++) {
            cadenaInicio += cadenaAux.charAt(i);
        }
        for (int i = longitud-1; longitud / 2 < i; i--) {
            cadenaFinal += cadenaAux.charAt(i);
        }
        String CIreplace = cadenaInicio.replace('á', 'a').replace('é', 'e').replace('í', 'i').replace('ó', 'o').replace('ú', 'u')
                .replace('Á', 'A').replace('É', 'E').replace('Í', 'I').replace('Ó', 'O').replace('Ú', 'U');
        String CFreplace = cadenaFinal.replace('á', 'a').replace('é', 'e').replace('í', 'i').replace('ó', 'o').replace('ú', 'u')
                .replace('Á', 'A').replace('É', 'E').replace('Í', 'I').replace('Ó', 'O').replace('Ú', 'U'); 
        return CIreplace.equalsIgnoreCase(CFreplace);
    }

}
