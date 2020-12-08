
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
public class SaludarGente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int NPersonas;
        String presentacion, nombre;
        Scanner sc = new Scanner(System.in);
        NPersonas = sc.nextInt();
        sc.nextLine();
        for (int i = 1; i <= NPersonas; i++) {
            presentacion = sc.nextLine();
            nombre = presentacion.replace("Soy", " ").trim();
            System.out.println("Hola, "+nombre+".");
        }
    }
}
