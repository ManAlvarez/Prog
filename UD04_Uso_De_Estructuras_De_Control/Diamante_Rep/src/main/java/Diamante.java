/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Manuel
 */
public class Diamante {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        diamante(8, '*');
    }

    public static void diamante(int n, char c) {
        if (n % 2 != 0 && n > 0 && n < 34) {
            for (int i = 1; i <= n; i = i + 2) {
                for (int d = n; d > i; d = d - 2) {
                    System.out.print(" ");
                }
                for (int d = 1; d <= i; d++) {
                    System.out.print(c);
                }
                System.out.println();
            }
            for (int i = n; i >= 1; i = i - 2) {
                for (int d = i; d < n + 2; d = d + 2) {
                    System.out.print(" ");
                }
                for (int d = i - 2; d > 0; d--) {
                    System.out.print(c);
                }
                System.out.println();
            }
        }
    }

}
