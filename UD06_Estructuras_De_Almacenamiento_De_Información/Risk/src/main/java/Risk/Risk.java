/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Risk;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Manuel
 */
public class Risk {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        while (true) {
            int[] datos = new int[5];
            for (int i = 0; i < datos.length; i++) {
                datos[i] = sc.nextInt();
            }
            if (datos[0] == 0 && datos[1] == 0 && datos[2] == 0 && datos[3] == 0 && datos[4] == 0) {
                break;
            }
            while (true) {

                int[] td = new int[datos[0]];
                int[] tdOrd = new int[datos[0]];
                int[] ta = new int[datos[1]];
                int[] taOrd = new int[datos[1]];
                int[] dd = new int[datos[2]];
                int[] da = new int[datos[3]];
                int[] no = new int[datos[4]];
                
                if (dd.length > td.length) {
                    for (int i = 0; i < td.length; i++) {
                        td[i] = sc.nextInt();
                    }
                } else {
                    td = new int[datos[2]];
                    tdOrd = new int[datos[2]];
                    for (int i = 0; i < dd.length; i++) {
                        td[i] = sc.nextInt();
                    }
                }

                if (da.length > ta.length) {
                    for (int i = 0; i < ta.length; i++) {
                        ta[i] = sc.nextInt();
                    }
                }else{
                    ta = new int[datos[3]];
                    taOrd = new int[datos[3]];
                    for (int i = 0; i < da.length; i++) {
                        ta[i] = sc.nextInt();
                    }
                }

                Arrays.sort(td);
                for (int i = td.length - 1, j = 0; i >= 0; i--, j++) {
                    tdOrd[j] = td[i];
                }

                Arrays.sort(ta);
                for (int i = ta.length - 1, j = 0; i >= 0; i--, j++) {
                    taOrd[j] = ta[i];
                }

                if (tdOrd.length <= taOrd.length) {
                    for (int i = 0; i < tdOrd.length; i++) {
                        if (tdOrd[i] >= taOrd[i]) {
                            datos[1] = datos[1] - 1;
                        } else {
                            datos[0] = datos[0] - 1;
                        }
                    }
                } else {
                    for (int i = 0; i < taOrd.length; i++) {
                        if (tdOrd[i] >= taOrd[i]) {
                            datos[1] = datos[1] - 1;
                        } else {
                            datos[0] = datos[0] - 1;
                        }
                    }
                }
                datos[4]--;
                if (datos[4] == 0) {
                    break;
                }
            }
            System.out.println(datos[0] + " " + datos[1]);
        }

    }

}
