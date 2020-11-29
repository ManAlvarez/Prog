/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Manuel
 */
public class Diamante {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        diamante(5, '#');
    }

    public static void diamante(int n, char c) {
        int i = 0, j = 0, k = 0;
        if (n % 2 != 0 && n > 0 && n < 34) {
            
            for (i = 1; i <= n; i = i + 2) {
                
                for (k = n; k > i; k = k - 2) {
                    System.out.print(" ");
                }   
                
                for (j = 0; j < i; j++) {
                    System.out.print(c);
                }
                
                System.out.println();
            }
            
            for (i = n; i >= 1; i = i - 2) {  
                
                for (k = i; k < n + 2; k = k + 2) {
                    System.out.print(" ");
                }    
                
                for (j = i - 2; j > 0; j--) {
                    System.out.print(c);
                }
                
                System.out.println();
            }
            
        }
    }

}
