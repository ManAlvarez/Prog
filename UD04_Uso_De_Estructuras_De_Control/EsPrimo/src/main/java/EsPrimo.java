/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Manuel
 */
public class EsPrimo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        esPrimo(13);
    }

    public static int esPrimo(int n) {
        int cont = 2;
        int primo = 1;
        if (n > 0) {
            while ((primo == 1) && (cont != n)) {
                if (n % cont == 0) {
                    primo = 0;
                }
                cont++;
            }
        } else {
            primo = -1;
        }
        return primo;
    }

}
