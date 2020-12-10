/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Manuel
 */
public class Wilkes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int cont = 0;
        for(int i = 0; i< 100; i++){
            System.out.printf("%04.0f ",Math.pow(i, 2));
            cont++;
            if(cont==10){
                System.out.println();
                cont = 0;
            }         
        }
    }
    
}
