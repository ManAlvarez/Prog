
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
public class CambiarDeCanal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int cIn, cFin, contBack, contNext;
        Scanner sc = new Scanner(System.in);
        while (true) {
            cIn = sc.nextInt();
            cFin = sc.nextInt();
            contBack = 0;
            contNext = 0;
            if (cIn == 0 || cFin == 0) {
                break;
            }
            for (int i = cIn; i != cFin; i++) {
                if (i == 100) {
                    i = 1;
                }
                contNext++;
            }
            for (int j = cIn; j != cFin; j--) {
                if (j == 1) {
                    j = 100;
                }
                contBack++;
            }
            if (contNext < contBack) {
                System.out.println(contNext);
            } else {
                System.out.println(contBack);
            }
        }
    }

}
