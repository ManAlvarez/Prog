/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Scanner;

/**
 *
 * @author Manuel
 */
public class NumerosPrimos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String result = "";
        if (n < 0) {
            System.out.println("Número no válido");
        } else {
            result="1,2";
            for (int i = 3; i <= n; i++) {
                if (esPrimo(i)) {
                    result += ","+i;
                }
            }
            System.out.println(result);
        }
    }

    public static boolean esPrimo(int n) {
        int cont = 2;
        boolean primo = true;
        while ((primo) && (cont != n)) {
            if (n % cont == 0) {
                primo = false;
            }
            cont++;
        }
        return primo;
    }
}
