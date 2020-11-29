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
public class OcurrenciasDeCaracteres {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String in = sc.next();
        boolean rep = true;
        int cont = 0;
        char letra = in.charAt(0);
        while (rep) {
            in = sc.next();
            for (int i = 0; i < in.length(); i++) {
                if ((in.charAt(i) + "").equals("<")) {
                    if ((in.charAt(i + 1) + "").equals(">")) {
                        rep = false;
                    }
                }
            }
            if(!rep)break;
            for (int i = 0; i < in.length(); i++) {
                if (in.charAt(i) == letra) {
                    cont++;
                }
            }
        }
        System.out.println(cont);
    }

}
