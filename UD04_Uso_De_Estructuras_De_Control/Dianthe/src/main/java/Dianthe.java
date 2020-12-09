
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Manuel
 */
public class Dianthe {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int n, piedras, resultado, piedrasSobrantes, sumador;
        Scanner sc = new Scanner(System.in);
        while (true) {
            n = sc.nextInt();
            if (n <= 0) {
                break;
            }
            piedras = 0;
            resultado = 0;
            sumador = 1;
            while (true) {
                resultado += sumador;
                sumador++;
                if (resultado == n) {
                    piedrasSobrantes = 0;
                    piedras++;
                    break;
                } else if (resultado > n) {
                    piedrasSobrantes = n - (resultado - (sumador - 1));
                    break;
                } else {
                    piedras++;
                }
            }
            System.out.println(piedras + " " + piedrasSobrantes);
        }
    }

}
