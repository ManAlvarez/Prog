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
    
    public void addCuentaBancaria(CuentaBancaria cuentaBancaria){
        this.cuentasBancarias[contador] = cuentaBancaria;
        contador++;
    }

       
}
