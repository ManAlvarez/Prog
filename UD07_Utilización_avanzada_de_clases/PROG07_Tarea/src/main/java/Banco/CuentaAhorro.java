/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Banco;

/**
 *
 * @author Manuel Clase publica para que sea accedible desde fuera de la clase,
 * que hereda de la clase abstracta CuentaBancaria todos sus métodos y
 * atributos.
 */
public class CuentaAhorro extends CuentaBancaria {

    // Atributo declarado como private, solo accesible desde la clase.
    private double tipoInteres;

    // Constructor.
    public CuentaAhorro() {
    }

    /**
     * Devuelve el tipo de interes de la cuenta de ahorro.
     *
     * @return double.
     */
    public double getTipoInteres() {
        return tipoInteres;
    }

    /**
     * Actualiza el tipo de interes.
     *
     * @param tipoInteres
     */
    public void setTipoInteres(double tipoInteres) {
        this.tipoInteres = tipoInteres;
    }

    /**
     * Sobrescribe el método de la interfaz que heredamos de la clase padre con
     * los datos de la cuenta de ahorro.
     *
     * @return String.
     */
    @Override
    public String devolverInfoString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CuentaAhorro{").append(titular.devolverInfoString());
        sb.append(", numeroCuenta=").append(numeroCuenta);
        sb.append(", saldo=").append(saldo);
        sb.append(", tipoInteres=").append(tipoInteres);
        sb.append('}');
        return sb.toString();
    }

}
