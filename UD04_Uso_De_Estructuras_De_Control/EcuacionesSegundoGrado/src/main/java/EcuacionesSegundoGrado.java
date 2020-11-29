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
public class EcuacionesSegundoGrado {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        double sol1;
        double sol2;
        double d;
        if (a == 0 && b == 0) {
            System.out.println("Coeficientes no válidos");
        } else if ((b * b - (4 * a * c)) < 0) {
            System.out.println("Sin solución real");
        } else if (a == 0) {
            d = b * b - (4 * a * c);
            sol1 = -b + Math.sqrt(d) / (2 * a);
            System.out.printf("X = %.2f", sol1);
        } else {
            d = b * b - (4 * a * c);
            if (d == 0) {
                sol1 = (-b + Math.sqrt(d)) / (2 * a);
                System.out.printf("X = %.2f", sol1);
            } else {
                sol1 = (-b + Math.sqrt(d)) / (2 * a);
                sol2 = (-b - Math.sqrt(d)) / (2 * a);
                System.out.printf("X1 = %.2f; ", sol1);
                System.out.printf("X2 = %.2f", sol2);
            }
        }
    }

}
