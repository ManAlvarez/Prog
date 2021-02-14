/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Manuel
 */
public class ArrayImpares {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int cont = 0;
        for (int i = -9; i <= 30; i++) {
            if (i % 2 != 0) {
                cont++;
            }
        }
        int[] impares = new int[cont];
        int indice = 0;
        for (int i = -9; i <= 30; i++) {
            if (i % 2 != 0) {
                impares[indice] = i;
                indice++;
            }
        }
    }

}
