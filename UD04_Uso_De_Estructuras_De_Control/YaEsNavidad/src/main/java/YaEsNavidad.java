
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
public class YaEsNavidad {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int NFechas, dia, mes;
        Scanner sc = new Scanner(System.in);
        NFechas = sc.nextInt();
        sc.nextLine();
        for(int i = 1 ; i<= NFechas; i++){
            dia = sc.nextInt();
            mes = sc.nextInt();
            if(dia == 25 && mes == 12)System.out.println("SI");
            else System.out.println("NO");
        }
    }
    
}
