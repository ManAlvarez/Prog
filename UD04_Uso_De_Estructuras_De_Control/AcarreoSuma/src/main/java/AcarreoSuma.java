
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
public class AcarreoSuma {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int n1, n2, suma, acarreo;
        String n1Str, n2Str;
        Scanner sc = new Scanner(System.in);
        while (true) {
            n1 = sc.nextInt();
            n2 = sc.nextInt();
            if (n1 == 0 && n2 == 0) {
                break;
            }
            n1Str = String.valueOf(n1);
            n2Str = String.valueOf(n2);
            suma = 0;
            acarreo = 0;
            for (int i = 0; i < n1Str.length(); i++) {
                suma += Integer.parseInt(n1Str.charAt(i) + "") + Integer.parseInt(n2Str.charAt(i) + "");
                if (suma > 9) {
                    suma = 1;
                    acarreo++;
                } else {
                    suma = 0;
                }
            }
            System.out.println(acarreo);
        }
    }

}
