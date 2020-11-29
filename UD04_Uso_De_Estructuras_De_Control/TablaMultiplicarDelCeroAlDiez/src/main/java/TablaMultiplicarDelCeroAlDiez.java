/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Manuel
 */
public class TablaMultiplicarDelCeroAlDiez {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("************************");
        System.out.println("* TABLA DE MULTIPLICAR *");
        System.out.println("************************\n");
        for (int i = 0; i <= 10; i++) {
            System.out.println("--------------");
            System.out.println(" TABLA DEL "+i);
            System.out.println("--------------");
            for (int j = 0; j <= 10; j++) {
                System.out.printf("%d x %d = %d\n", i, j, i * j);
            }
        }
    }

}
