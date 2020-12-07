
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
public class CoccionDeHuevos {

    /**
     * @param args the command line arguments
     */
    private static final int COCCION = 10;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nHuevos, capacidad, tCoccion;
        while (true) {
            nHuevos = sc.nextInt();
            if (nHuevos == 0) {
                break;
            }
            capacidad = sc.nextInt(); 
            if (capacidad == 0) {
                break;
            }
            tCoccion = COCCION * nOllas(nHuevos, capacidad);
            System.out.println(tCoccion);
        }
    }

    public static int nOllas(int huevos, int capacidad) {
        int cont = 0;
        while (0 < huevos) {
            huevos -= capacidad;
            cont++;
        }
        return cont;
    }
}
