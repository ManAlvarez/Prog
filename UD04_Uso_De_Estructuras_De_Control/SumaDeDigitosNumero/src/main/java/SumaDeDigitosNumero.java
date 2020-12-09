
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
public class SumaDeDigitosNumero {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int n, resultado;
        String num, cadena;
        Scanner sc = new Scanner(System.in);
        while (true) {
            num = "";
            cadena = "";
            resultado = 0;
            n = sc.nextInt();
            if (n < 0) {
                break;
            }
            num = String.valueOf(n);
            for (int i = 0; i < num.length(); i++) {
                if (num.length() - 1 == i) {
                    cadena += num.charAt(i);
                } else {
                    cadena += num.charAt(i) + " + ";
                }
                resultado += Integer.parseInt(num.charAt(i) + "");
            }
            System.out.println(cadena + " = " + resultado);
        }
    }

}
