/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Banco;

/**
 *
 * @author Manuel
 */
public class Banco {

    private CuentaBancaria[] cuentasBancarias = new CuentaBancaria[100];
    private static int contador = 0;

    public Banco() {
    }

    public CuentaBancaria[] getCuentasBancarias() {
        return cuentasBancarias;
    }

    public void setCuentasBancarias(CuentaBancaria[] cuentasBancarias) {
        this.cuentasBancarias = cuentasBancarias;
    }

    /**
     * Recibe por parámetro un objeto CuentaBancaria y lo almacena en la
     * estructura. Devuelve true o false indicando si la operación se realizó
     * con éxito.
     *
     * @param cuentaBancaria
     * @return true or false.
     */
    public boolean abrirCuenta(CuentaBancaria cuentaBancaria) {
        if (contador < 100) {
            this.cuentasBancarias[contador] = cuentaBancaria;
            contador++;
            return true;
        } else {
            return false;
        }
    }

    /**
     * No recibe parámetro y devuelve un array donde cada elemento es una cadena
     * que representa la información de una cuenta.
     *
     * @return String[].
     */
    public String[] listadoCuentas() {
        String[] cuentas = new String[contador];
        for (int i = 0; i < cuentas.length; i++) {
               cuentas[i] = cuentasBancarias[i].devolverInfoString();
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
        for (int i = 0; i < contador; i++) {
            if(cuentasBancarias[i].numeroCuenta.equals(IBAN)){
                return cuentasBancarias[i].devolverInfoString();
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
        for (int i = 0; i < contador; i++) {
            if(cuentasBancarias[i].numeroCuenta.equals(IBAN)){
                cuentasBancarias[i].saldo += cantidadAIngresar;
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
        for (int i = 0; i < contador; i++) {
            if(cuentasBancarias[i].numeroCuenta.equals(IBAN)){
                cuentasBancarias[i].saldo -= cantidadARetirar;
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
        for (int i = 0; i < contador; i++) {
            if(cuentasBancarias[i].numeroCuenta.equals(IBAN)){
                return cuentasBancarias[i].saldo;
            }
        }
        return -1;
    }   

}
