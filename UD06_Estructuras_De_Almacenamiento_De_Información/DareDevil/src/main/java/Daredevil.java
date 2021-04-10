
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
public class Daredevil {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int filas = sc.nextInt();
            int columnas = sc.nextInt();
            if (filas == 0 || columnas == 0) {
                break;
            }
            char[][] mapa = new char[filas][columnas];
            for (int i = 0; i < mapa.length; i++) {
                String linea = sc.next();
                for (int j = 0; j < mapa[i].length; j++) {
                    mapa[i][j] = linea.charAt(j);
                }
            }
            int contCeldasVillano = 0;
            boolean encontrado = false;
            int casos = sc.nextInt();
            for (int i = 0; i < casos; i++) {
                int posFila = sc.nextInt() - 1;
                int posColumna = sc.nextInt() - 1;
                String direccion = sc.next();
                switch (direccion) {
                    case "ARRIBA":
                        for(int f = posFila; f>= 0; f--){
                            if(mapa[f][posColumna] == '.' && encontrado == false) contCeldasVillano++;
                            else if(mapa[f][posColumna] == 'X') encontrado = true;
                        }
                        break;
                    case "ABAJO":
                        for(int f = posFila; f<mapa.length; f++){
                            if(mapa[f][posColumna] == '.' && encontrado == false) contCeldasVillano++;
                            else if(mapa[f][posColumna] == 'X') encontrado = true;
                        }
                        break;
                    case "IZQUIERDA":
                        for(int c = posColumna; c>= 0; c--){
                            if(mapa[posFila][c] == '.' && encontrado == false) contCeldasVillano++;
                            else if(mapa[posFila][c] == 'X') encontrado = true;
                        }
                        break;
                    case "DERECHA":
                        for(int c = posColumna; c<mapa[posFila].length; c++){
                            if(mapa[posFila][c] == '.' && encontrado == false) contCeldasVillano++;
                            else if(mapa[posFila][c] == 'X') encontrado = true;
                        }
                        break;
                }
                if(encontrado == false)System.out.println("NINGUNO");
                else System.out.println(contCeldasVillano);
                contCeldasVillano = 0;
                encontrado = false;
            }
        }
    }
}
