/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Manuel
 */
public class Bernouilli {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> ns = new ArrayList<>();
        ArrayList<Integer> ps = new ArrayList<>();
        boolean rep = true;
        while (rep) {
            int n = sc.nextInt();
            int p = sc.nextInt();
            if (n == p && p == 0) {
                rep = false;
                break;
            }
            ns.add(n);
            ps.add(p);
        }
        for (int i = 0; i <= ns.size() - 1; i++) {
            if (ns.get(i) > 0 && ns.get(i) < 11 && ps.get(i) > 0 && ps.get(i) < 11) {
                System.out.println(Faulhaber(ns.get(i), ps.get(i)));
            }
        }
    }

    public static long Faulhaber(int n, int p) {
        long result = 0;
        for (int i = 1; i <= n; i++) {
            result += Math.pow(i, p);
        }
        return result;
    }

}
