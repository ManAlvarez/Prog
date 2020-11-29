/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Scanner;

/**
 *
 * @author Manuel
 */
public class IgualMayor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int n3 = sc.nextInt();
        if (n1 == n2 && n1 == n3) {
            System.out.println("3 iguales");
        } else {
            if (n1 > n2) {
                if (n1 > n3) {
                    System.out.println(n1);
                } else {
                    System.out.println(n3);
                }
            } else if (n2 > n3) {
                System.out.println(n2);
            } else {
                System.out.println( n3);
            }
        }
    }

}
