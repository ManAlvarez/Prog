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
public class TablaMultiplicar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n < 0 || n > 9) {
            System.out.println("Número no válido");
        } else {
            for (int i = 0; i <= 10; i++) {
                System.out.printf("%d x %d = %d\n",n,i,n*i);
            }
        }
    }
}
