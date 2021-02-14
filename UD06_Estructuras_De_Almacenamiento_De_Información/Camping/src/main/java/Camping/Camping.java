/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Camping;

import java.util.Scanner;

/**
 *
 * @author Manuel
 */
public class Camping {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] datos = new int[3];
        while (true) {
            for (int i = 0; i < datos.length; i++) {
                datos[i] = sc.nextInt();
            }
            if (datos[0] == 0 && datos[1] == 0 && datos[2] == 0) {
                break;
            }

            int[][] cuadro = new int[datos[0]][datos[1]];

            for (int i = 0; i < datos[2]; i++) {
                int c = sc.nextInt();
                int f = sc.nextInt();
                cuadro[c - 1][f - 1] = 1;
            }

            for (int i = 0; i < cuadro.length; i++) {
                for (int j = 0; j < cuadro[i].length; j++) {
                    if (cuadro[i][j] == 1) {
                        if (i > 0) {
                            if (cuadro[i - 1][j] == 0) {
                                cuadro[i - 1][j] = 2;
                            }
                            if (j > 0) {
                                if (cuadro[i - 1][j - 1] == 0) {
                                    cuadro[i - 1][j - 1] = 2;
                                }
                            }
                            if (j < cuadro[i].length - 1) {
                                if (cuadro[i - 1][j + 1] == 0) {
                                    cuadro[i - 1][j + 1] = 2;
                                }
                            }
                        }
                        if (i < cuadro.length - 1) {
                            if (cuadro[i + 1][j] == 0) {
                                cuadro[i + 1][j] = 2;
                            }
                            if (j > 0) {
                                if (cuadro[i + 1][j - 1] == 0) {
                                    cuadro[i + 1][j - 1] = 2;
                                }
                            }
                            if (j < cuadro[i].length - 1) {
                                if (cuadro[i + 1][j + 1] == 0) {
                                    cuadro[i + 1][j + 1] = 2;
                                }
                            }
                        }
                        if (j > 0) {
                            if (cuadro[i][j - 1] == 0) {
                                cuadro[i][j - 1] = 2;
                            }
                        }
                        if (j < cuadro[i].length - 1) {
                            {
                                if (cuadro[i][j + 1] == 0) {
                                    cuadro[i][j + 1] = 2;
                                }
                            }
                        }
                    }
                }               
            }

            int cont = 0;
            for (int i = 0; i < cuadro.length; i++) {
                for (int j = 0; j < cuadro[i].length; j++) {
                    if(cuadro[i][j] == 2){
                        cont++;
                    }
                }
            }
            System.out.println(cont);

        }
    }

}
