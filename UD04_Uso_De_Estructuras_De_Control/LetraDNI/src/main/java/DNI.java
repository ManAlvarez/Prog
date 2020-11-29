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
public class DNI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] letras = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
        int num = -1;
        String dni = sc.nextLine();
        try {
            num = Integer.parseInt(dni);
            if (dni.length() < 8 || dni.length() > 8) {
                System.out.println("DNI no válido");
            } else {
                int resto = num % 23;
                System.out.println(letras[resto]);
            }
        } catch (NumberFormatException e) {
            System.out.println("DNI no válido");
        }

    }

}
