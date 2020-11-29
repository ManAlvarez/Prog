/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Manuel
 */
public class MensajesOcultos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<String> titulares = new ArrayList<>();
        ArrayList<String> mensajes = new ArrayList<>();
        String titular;
        String mensaje = "";
        Scanner sc = new Scanner(System.in);
        int nCasos = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < nCasos; i++) {
            titular = sc.nextLine();
            titulares.add(titular);
            mensaje = sc.nextLine();
            mensajes.add(mensaje);
        }
        for (int i = 0; i < nCasos; i++) {
            System.out.println(buscarMensaje(titulares.get(i), mensajes.get(i)));
        }
    }

    public static String buscarMensaje(String t, String m) {
        m = m.replace(" ", "").toUpperCase();
        t = t.replace(" ", "").toUpperCase();
        int cont = 0;
        ArrayList<Character> caracteresM = new ArrayList<>();
        ArrayList<Character> caracteresT = new ArrayList<>();
        for (int i = 0; i < m.length(); i++) {
            caracteresM.add(m.charAt(i));
        }
        for (int i = 0; i < t.length(); i++) {
            caracteresT.add(t.charAt(i));
        }
        for (int i = 0; i < caracteresM.size(); i++) {
            for (int j = 0; j < caracteresT.size(); j++) {
                if (caracteresM.get(i).equals(caracteresT.get(j))) {
                    cont++;
                    break;
                }
            }
        }
        if (m.length() == cont) {
            return "SI";
        } else {
            return "NO";
        }
    }

}
