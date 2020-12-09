
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
public class Base1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String cadena;
        int n;
        Scanner sc = new Scanner(System.in);
        while (true) {
            cadena = "";
            n = sc.nextInt();
            if(n == 0)break;
            for (int i = 1; i <= n; i++) {
                cadena += "1";
            }
            System.out.println(cadena);
        }
    }

}
