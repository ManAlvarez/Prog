
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
public class Ascensor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int nPisoIni, nPiso, longitud;
        Scanner sc = new Scanner(System.in);
        while (true) {
            longitud = 0;
            nPisoIni = sc.nextInt();
            if (nPisoIni < 0) {
                break;
            }
            while (true) {
                nPiso = sc.nextInt();
                if (nPiso == -1) {
                    break;
                }
                longitud += Math.abs(nPisoIni - nPiso);
                nPisoIni = nPiso;
            }
            System.out.println(longitud);
        }
    }

}
