/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Banco;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Manuel Clase pública donde almacenamos y hacemos operaciones sobre
 * las cuentas bancarias.
 */
public class Banco {

    // Atributos declarados como private, solo accesibles desde la clase. 
    // ArrayList para almacenar todas las cuentas que creamos.
    /* Justificación:
    
        1. Los ArrayList son más rápidos en cuanto a acceso a los elementos.
        2. Si no se van a realizar muchas eliminaciones, sino que solamente 
        se van a insertar y consultar elementos por posición, conviene usar 
        una lista basada en arrays redimensionados (ArrayList).
    
     */
    private ArrayList<CuentaBancaria> cuentasBancarias = new ArrayList<CuentaBancaria>();
    private ObjectInputStream lectorDeObjetos;
    private ObjectOutputStream escritorDeObjetos;

    // Constructor.
    public Banco() {
    }

    /**
     * Devuelve un ArrayList con las cuentas bancarias del banco.
     *
     * @return ArrayList.
     */
    public ArrayList<CuentaBancaria> getCuentasBancarias() {
        return cuentasBancarias;
    }

    /**
     * Actualiza el ArrayList de cuentas bancarias.
     *
     * @param cuentasBancarias
     */
    public void setCuentasBancarias(ArrayList<CuentaBancaria> cuentasBancarias) {
        this.cuentasBancarias = cuentasBancarias;
    }

    /**
     * Recibe por parámetro un objeto CuentaBancaria y lo almacena en la
     * estructura.
     *
     * @param cuentaBancaria
     * @return true.
     */
    public boolean abrirCuenta(CuentaBancaria cuentaBancaria) {
        cuentasBancarias.add(cuentaBancaria);
        return true;
    }

    /**
     * No recibe parámetro y devuelve un array donde cada elemento es una cadena
     * que representa la información de una cuenta.
     *
     * @return String[].
     */
    public String[] listadoCuentas() {
        String[] cuentas = new String[cuentasBancarias.size()];
        for (CuentaBancaria cuentaBancariaAux : cuentasBancarias) {
            cuentas[cuentasBancarias.indexOf(cuentaBancariaAux)] = cuentaBancariaAux.devolverInfoString();
        }
        return cuentas;
    }

    /**
     * Recibe un iban por parámetro y devuelve una cadena con la información de
     * la cuenta o null si la cuenta no existe.
     *
     * @param IBAN
     * @return true or false.
     */
    public String informacionCuenta(String IBAN) {
        for (CuentaBancaria cuentaBancariaAux : cuentasBancarias) {
            if (cuentaBancariaAux.numeroCuenta.equals(IBAN)) {
                return cuentaBancariaAux.devolverInfoString();
            }
        }
        return null;
    }

    /**
     * Recibe un iban por parámetro y una cantidad e ingresa la cantidad en la
     * cuenta. Devuelve true o false indicando si la operación se realizó con
     * éxito.
     *
     * @param IBAN
     * @param cantidadAIngresar
     * @return true or false.
     */
    public boolean ingresoCuenta(String IBAN, double cantidadAIngresar) {
        for (CuentaBancaria cuentaBancariaAux : cuentasBancarias) {
            if (cuentaBancariaAux.numeroCuenta.equals(IBAN)) {
                cuentaBancariaAux.saldo += cantidadAIngresar;
                return true;
            }
        }
        return false;
    }

    /**
     * Recibe un iban por parámetro y una cantidad y trata de retirar la
     * cantidad de la cuenta. Devuelve true o false indicando si la operación se
     * realizó con éxito.
     *
     * @param IBAN
     * @param cantidadARetirar
     * @return true or false;
     */
    public boolean retiradaCuenta(String IBAN, double cantidadARetirar) {
        for (CuentaBancaria cuentaBancariaAux : cuentasBancarias) {
            if (cuentaBancariaAux.numeroCuenta.equals(IBAN)) {
                cuentaBancariaAux.saldo -= cantidadARetirar;
                return true;
            }
        }
        return false;
    }

    /**
     * Recibe un iban por parámetro y devuelve el saldo de la cuenta si existe.
     * En caso contrario devuelve -1
     *
     * @param IBAN
     * @return double.
     */
    public double obtenerSaldo(String IBAN) {
        for (CuentaBancaria cuentaBancariaAux : cuentasBancarias) {
            if (cuentaBancariaAux.numeroCuenta.equals(IBAN)) {
                return cuentaBancariaAux.saldo;
            }
        }
        return -1;
    }

    /**
     * Recibe un iban por parámetro y elimina la cuenta de la lista si la cuenta
     * existe.
     *
     * @param IBAN
     * @return
     */
    public boolean eliminarCuenta(String IBAN) {
        ListIterator<CuentaBancaria> it = cuentasBancarias.listIterator();
        while (it.hasNext()) {
            if (it.next().numeroCuenta.equals(IBAN)) {
                it.remove();
                return true;
            }
        }
        return false;
    }

    // Método que escribe una lista de cuentas bancarias en un archivo.
    public void escribirObjeto() {
        try {
            escritorDeObjetos = new ObjectOutputStream(new FileOutputStream("datoscuentasbancarias.dat"));
            escritorDeObjetos.writeObject(cuentasBancarias);
        } catch (IOException ex) {
            Logger.getLogger(Banco.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Método que almacena en la lista cuentasBancarias lo que lee de un archivo.
    public void leerObjeto() {
        try {
            lectorDeObjetos = new ObjectInputStream(new FileInputStream("datoscuentasbancarias.dat"));
            cuentasBancarias = (ArrayList<CuentaBancaria>) lectorDeObjetos.readObject();
        } catch (FileNotFoundException ex) {
            System.out.println("No hay datos.");
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(Banco.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
