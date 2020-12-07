
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
public class TriangulosConCerillas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int cerillasTriangulo, cerillasLado;

        while (true) {
            cerillasLado = sc.nextInt();
            cerillasTriangulo = 0;
            if (cerillasLado > 0 && cerillasLado <= 20000) {
                for (int i = 1; i <= cerillasLado; i++) {
                    cerillasTriangulo += 3 * i;
                }
            } else {
                break;
            }          
            System.out.println(cerillasTriangulo);
        }
    }

}
