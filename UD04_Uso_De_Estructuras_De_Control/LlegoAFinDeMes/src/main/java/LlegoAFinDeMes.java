
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
public class LlegoAFinDeMes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int CasosDePrueba, ingresos, gastos, resultado;
        Scanner sc = new Scanner(System.in);
        CasosDePrueba = sc.nextInt();
        sc.nextLine();
        for (int i = 1; i <= CasosDePrueba; i++) {
            ingresos = sc.nextInt();
            gastos = sc.nextInt();
            if (ingresos < 0 || gastos < 0) {
                resultado = ingresos + gastos;
            } else {
                resultado = ingresos - gastos;
            }
            if (resultado > 0) {
                System.out.println("SI");
            } else {
                System.out.println("NO");
            }
        }
    }
}
