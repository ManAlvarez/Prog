
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
public class MontanaRusa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        while (true) {
            int cont = 0;
            int casos = sc.nextInt();
            if (casos == 0) {
                break;
            }
            int[] picos = new int[casos];
            for (int i = 0; i < picos.length; i++) {
                picos[i] = sc.nextInt();
            }
            for (int i = 0; i < picos.length; i++) {
                if (i > 0 && i < picos.length - 1) {
                    if (picos[i - 1] < picos[i] && picos[i + 1] < picos[i]) {
                        cont++;
                    }
                } else if (i == 0) {
                    if (picos[i + 1] < picos[i]) {
                        cont++;
                    }
                } else if (i == picos.length - 1) {
                    if (picos[i - 1] < picos[i] && picos[0] < picos[i]) {
                        cont++;
                    }
                }
            }
            System.out.println(cont);
        }

    }

}
