
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
public class Bernouilli {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int n, p;
        long result;
        Scanner sc = new Scanner(System.in);
        while (true) {
            result = 0;
            n = sc.nextInt();
            p = sc.nextInt();
            if (n == 0 && p == 0) {
                break;
            }
            if ((n >= 1 && n <= 10) && (p >= 1 && p <= 10)) {
                for (int i = 1; i <= n; i++) {
                    result += Math.pow(i, p);
                }
                System.out.println(result);
            }
        }
    }

}
