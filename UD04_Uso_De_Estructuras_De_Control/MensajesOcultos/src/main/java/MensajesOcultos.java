
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
public class MensajesOcultos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String titular, mensaje;
        int nCasos, cont;
        Scanner sc = new Scanner(System.in);
        nCasos = sc.nextInt();
        sc.nextLine();
        for (int i = 1; i <= nCasos; i++) {
            cont = 0;
            titular = sc.nextLine().trim().replace(" ", "");
            mensaje = sc.nextLine().trim().replace(" ", "");
            for (int j = 0; j < mensaje.length(); j++) {
                for (int k = 0; k < titular.length(); k++) {
                    if (String.valueOf(titular.charAt(k)).equalsIgnoreCase(String.valueOf(mensaje.charAt(j)))) {
                        cont++;
                        break;
                    }
                }
            }
            if (cont == mensaje.length()) {
                System.out.println("SI");
            } else {
                System.out.println("NO");
            }
        }
    }
}
