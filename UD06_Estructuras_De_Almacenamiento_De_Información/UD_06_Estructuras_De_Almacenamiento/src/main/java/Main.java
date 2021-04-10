

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Manuel
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[][] prueba = new int[5][5];
        for(int i = 0; i<prueba.length; i++){
            for(int j = 0; j<prueba[i].length; j++){
                prueba[i][j] = i*j;               
            }
        }
     
        for(int i = 0; i<prueba.length; i++){
            for(int j = 0; j<prueba[i].length; j++){
                System.out.print(prueba[i][j]);          
            }
            System.out.println("");
        }
        
        for(int i = 0; i<prueba.length; i++){
            for(int j = 0; j<prueba[i].length; j++){
                System.out.print(prueba[j][i]);          
            }
            System.out.println("");
        }
       
    }

}
