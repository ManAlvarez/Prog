
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
public class BuscaMinas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int contMinas = 0;
        int contLetraRodeada = 0;
        while (true) {
            int ancho = sc.nextInt();
            int alto = sc.nextInt();
            if (ancho == 0 || alto == 0) {
                break;
            }
            char[][] tablero = new char[alto][ancho];
            for (int i = 0; i < tablero.length; i++) {
                String linea = sc.next();
                for (int j = 0; j < tablero[i].length; j++) {
                    tablero[i][j] = linea.charAt(j);
                }
            }            
            for (int i = 0; i < tablero.length; i++) {
                for (int j = 0; j < tablero[i].length; j++) {
                    contMinas = 0;
                    if (i > 0 && i < tablero.length - 1 && j > 0 && j < tablero[i].length - 1) {
                        if (tablero[i - 1][j - 1] == '*')contMinas++;
                        if (tablero[i - 1][j] == '*')contMinas++;
                        if (tablero[i - 1][j + 1] == '*')contMinas++;
                        if (tablero[i + 1][j - 1] == '*')contMinas++;
                        if (tablero[i + 1][j] == '*')contMinas++;
                        if (tablero[i + 1][j + 1] == '*')contMinas++;
                        if (tablero[i][j - 1] == '*')contMinas++;
                        if (tablero[i][j + 1] == '*')contMinas++;
                        if(contMinas>=6)contLetraRodeada++;
                    }
                }
            }
            System.out.println(contLetraRodeada);
            contLetraRodeada=0;
        }

    }

}
