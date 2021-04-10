
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
public class HalconMilenario {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int filas = sc.nextInt();
            int columnas = sc.nextInt();
            int posFilaIni = 0, posColIni = 0;
            if (filas == 0 || columnas == 0) {
                break;
            }
            char[][] mapa = new char[filas][columnas];
            for (int i = 0; i < mapa.length; i++) {
                String linea = sc.next();
                for (int j = 0; j < mapa[i].length; j++) {
                    mapa[i][j] = linea.charAt(j);
                    if (linea.charAt(j) == 'S') {
                        posFilaIni = i;
                        posColIni = j;
                    }               
                }
            }
            System.out.println((comprobarRuta(posFilaIni, posColIni, mapa))?"SI":"NO");
        }
    }
    
    private static boolean comprobarRuta(int fila, int columna, char[][] mapa) {
        boolean ruta = false;

        char c = mapa[fila][columna];

        if(c=='F') return true;    // Es la salida
        if(c=='*' || c=='V') return false;  // No transitable

        mapa[fila][columna] = 'V';  // Marcamos la celda como visitada

        // Izquierda
        if(columna>0) ruta = comprobarRuta(fila, columna-1, mapa);

        // Abajo
        if(!ruta && fila<mapa.length-1) ruta = comprobarRuta(fila+1, columna, mapa);

        // Derecha
        if(!ruta && columna<mapa[0].length-1) ruta = comprobarRuta(fila, columna+1, mapa);

        // Arriba
        if(!ruta && fila>0) ruta = comprobarRuta(fila-1, columna, mapa);

        return ruta;
    }    

}
