
package PROG05_Ejerc1_util;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Manuel
 * Clase con herramientas utiles para el tratamiento de datos.
 * Clase publica para que sea accedible desde fuera de la clase.
 */

public class Herramienta {

    /**
     * Método para insertar un número entero a través de teclado.
     * Es un método público para que sea accedible desde fuera de la clase y estático para que se pueda ejecutar sin una instancia de la clase.
     * @return int
     */
    public static int insertarNumero() {
        int num = -1; 
        try {
            Scanner teclado = new Scanner(System.in);
            num = teclado.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Debes ingresar un número entero.");
            num = -1;
        }
        return num;
    }
    
    /**
     * Método para insertar un número decimal a través de teclado.
     * Es un método público para que sea accedible desde fuera de la clase y estático para que se pueda ejecutar sin una instancia de la clase.
     * @return double
     */
    public static double insertarNumeroDecimal() {
        double num = -1;
        try {
            Scanner teclado = new Scanner(System.in);
            num = teclado.nextDouble();
        } catch (InputMismatchException e) {
            System.out.println("Debes ingresar un número.");
            num = -1;
        }
        return num;
    }
    
    /**
     * Método para validar el formato de un dni pasado como parámetro.
     * Es un método público para que sea accedible desde fuera de la clase y estático para que se pueda ejecutar sin una instancia de la clase.
     * @param dni
     * @return boolean
     */
    public static boolean validarDni(String dni){
        Pattern patron = Pattern.compile("[0-9]{7,8}[A-Z a-z]"); //Patrón para validar el dni.
        Matcher mat = patron.matcher(dni);
        if(!mat.matches()){
           System.out.println("DNI incorrecto.");
           return false;
        }
        return true;
    }
    
    /**
     * Método para insertar una cadena a través del teclado.
     * Es un método público para que sea accedible desde fuera de la clase y estático para que se pueda ejecutar sin una instancia de la clase.
     * @return String
     */
    public static String insertarCadena() {
        Scanner sc = new Scanner(System.in);
        String cadena = sc.nextLine();
        return cadena;
    }
    
    /**
     * Método para hacer una pausa en la consola y esperar hasta pulsar una tecla.
     * Es un método público para que sea accedible desde fuera de la clase y estático para que se pueda ejecutar sin una instancia de la clase.
     */
    public static void pulsarEnter() {
        System.out.println("Pulsa enter para continuar....");
        Scanner sc = new Scanner(System.in);
        String cadena = sc.nextLine();
    }
    
    /**
     * Método para limpiar la consola, creando el número de lineas en blanco que le indicamos en el parámetro.
     * Es un método público para que sea accedible desde fuera de la clase y estático para que se pueda ejecutar sin una instancia de la clase.
     * @param numLineas 
     */
    public static void limpiarConsola(int numLineas){
        for(int i = 0; i<= numLineas; i++){
            System.out.println("");
        }
    }

}
