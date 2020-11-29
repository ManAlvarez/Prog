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
public class SumaMediaMayorMenor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String rep = "";
        float valor = 0, valorAnt = 0, min = 0, max = 0, suma = 0;
        double media = 0;
        int cont = 0;
        do {
            rep = sc.next().replace(',', '.');
            valor = Float.parseFloat(rep);
            suma += valor;
            if (valor < valorAnt) {
                min = valor;
            }
            if (valor > valorAnt) {
                max = valor;
            }
            cont++;
        } while (!rep.equals("00"));
        if(min==0 && max==0){
            System.out.println("No hay datos");
        }else{
             media = suma / (cont - 1);
        System.out.printf("Min: %.2f\n", min);
        System.out.printf("Max: %.2f\n", max);
        System.out.printf("Suma: %.2f\n", suma);
        System.out.printf("Media: %.2f\n", media);
        }     
    }

}
