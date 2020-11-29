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
public class Granja {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int comidaDiaria = sc.nextInt();
        int numAnimales = sc.nextInt();
        double kilosPorAnimal = sc.nextDouble();
        double excedente = comidaDiaria - (numAnimales * kilosPorAnimal);
        if (excedente < 0) {
            double cD = Double.parseDouble(String.valueOf(comidaDiaria));
            double nA = Double.parseDouble(String.valueOf(numAnimales));
            double racion = cD / nA;
            System.out.printf("Ración = %.2f Kg",racion);
        }else{
            System.out.printf("Excedente = %.1f Kg",excedente);
        }
    }
}
