/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Banco;

import java.util.ArrayList;

/**
 *
 * @author Manuel Clase pública donde almacenamos y hacemos operaciones sobre
 * las cuentas bancarias.
 */
public class Banco {

    // Atributos declarados como private, solo accesibles desde la clase. 
    // ArrayList para almacenar todas las cuentas que creamos.
    private ArrayList<CuentaBancaria> cuentasBancarias = new ArrayList<CuentaBancaria>();
    // Contador para dimensinar el array.
    private static int contador = 0;

    // Constructor.
    public Banco() {
    }

    /**
     * Devuelve un ArrayList con las cuentas bancarias del banco.
     * @return ArrayList.
     */
    public ArrayList<CuentaBancaria> getCuentasBancarias() {
        return cuentasBancarias;
    }

    /**
     * Actualiza el ArrayList de cuentas bancarias.
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
        for(CuentaBancaria cuentaBancariaAux: cuentasBancarias){
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
        for(CuentaBancaria cuentaBancariaAux:cuentasBancarias){
            if(cuentaBancariaAux.numeroCuenta.equals(IBAN)){
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
        for(CuentaBancaria cuentaBancariaAux:cuentasBancarias){
            if(cuentaBancariaAux.numeroCuenta.equals(IBAN)){
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
        for(CuentaBancaria cuentaBancariaAux:cuentasBancarias){
            if(cuentaBancariaAux.numeroCuenta.equals(IBAN)){
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
     * @return
     */
    public double obtenerSaldo(String IBAN) {
        for(CuentaBancaria cuentaBancariaAux:cuentasBancarias){
            if(cuentaBancariaAux.numeroCuenta.equals(IBAN)){
                return cuentaBancariaAux.saldo;
            }
        }
        return -1;
    }

}
