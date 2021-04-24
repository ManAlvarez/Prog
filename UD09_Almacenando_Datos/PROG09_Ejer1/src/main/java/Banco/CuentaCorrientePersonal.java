/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Banco;

import java.io.Serializable;

/**
 *
 * @author Manuel Clase publica para que sea accedible desde fuera de la clase,
 * que hereda de la clase abstracta CuentaCorriente todos sus metodos y
 * atributos.
 */
public class CuentaCorrientePersonal extends CuentaCorriente implements Serializable {

    // Atributo declarado como private, solo accesible desde la clase.
    private double comisionMantenimiento;

    // Constructor.
    public CuentaCorrientePersonal() {
    }

    /**
     * Devuelve la comisión de mantenimiento de la cuenta corriente personal.
     *
     * @return double.
     */
    public double getComisionMantenimiento() {
        return comisionMantenimiento;
    }

    /**
     * Actualiza la comisión de mantenimiento.
     *
     * @param comisionMantenimiento
     */
    public void setComisionMantenimiento(double comisionMantenimiento) {
        this.comisionMantenimiento = comisionMantenimiento;
    }

    /**
     * Sobrescribe el método de la interfaz Imprimible que heredamos de la clase
     * padre con los datos de la cuenta corriente personal.
     *
     * @return
     */
    @Override
    public String devolverInfoString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CuentaCorrientePersonal{").append(titular.devolverInfoString());
        sb.append(", numeroCuenta=").append(numeroCuenta);
        sb.append(", saldo=").append(saldo);
        sb.append(" [ ");
        sb.append("entidadesAutorizadas=").append(entidadesAutorizadas);
        sb.append(", comisionMantenimiento=").append(comisionMantenimiento);
        sb.append(" ]");
        sb.append('}');
        return sb.toString();
    }

}
