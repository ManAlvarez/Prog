
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
public class Artropodos {

    /**
     * @param args the command line arguments
     */
    private static final int NP_INSECTOS = 6;
    private static final int NP_ARACNIDOS = 8;
    private static final int NP_CRUSTACEOS = 10;
    private static final int NP_SEGMENTO = 2;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int casosDePruebas, nInsectos, nAracnidos, nCrustaceos, nEscolopendras, nAnillosEscolopendras;
        casosDePruebas = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < casosDePruebas; i++) {
            nInsectos = sc.nextInt();
            nAracnidos = sc.nextInt();
            nCrustaceos = sc.nextInt();
            nEscolopendras = sc.nextInt();
            nAnillosEscolopendras = sc.nextInt();
            System.out.println((nInsectos * NP_INSECTOS) + (nAracnidos * NP_ARACNIDOS) + (nCrustaceos * NP_CRUSTACEOS) + (nEscolopendras * NP_SEGMENTO * nAnillosEscolopendras));
        }
    }
}
