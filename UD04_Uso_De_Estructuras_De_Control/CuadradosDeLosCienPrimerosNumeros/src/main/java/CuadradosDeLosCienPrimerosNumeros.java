/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Manuel
 */
public class CuadradosDeLosCienPrimerosNumeros {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int cont = 1;
        for (int i = 0; i <= 99; i++) {
            if (cont > 10) {
                System.out.print("\n");
                cont = 1;
            }
            System.out.print(String.format("%04d", i * i) + "  ");
            cont++;
        }
    }

}
