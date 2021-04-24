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
public class CuentaCorrienteEmpresa extends CuentaCorriente implements Serializable {

    // Atributos declarados como private, solo accesibles desde la clase.
    private double tipoInteresDescubierto;
    private double maxDescubiertoPermitido;
    private double comisionFijaPorDescubierto;

    // Constructor.
    public CuentaCorrienteEmpresa() {
    }

    /**
     * Devuelva el tipo de interes por descubierto de la cuenta corriente de la
     * Empresa.
     *
     * @return double.
     */
    public double getTipoInteresDescubierto() {
        return tipoInteresDescubierto;
    }

    /**
     * Actualiza el tipo de interes por descubierto.
     *
     * @param tipoInteresDescubierto
     */
    public void setTipoInteresDescubierto(double tipoInteresDescubierto) {
        this.tipoInteresDescubierto = tipoInteresDescubierto;
    }

    /**
     * Devuelve el máximo descubierto permitido de la cuenta corriente de la
     * Empresa.
     *
     * @return double.
     */
    public double getMaxDescubiertoPermitido() {
        return maxDescubiertoPermitido;
    }

    /**
     * Actualiza el máximo descubierto permitido.
     *
     * @param maxDescubiertoPermitido
     */
    public void setMaxDescubiertoPermitido(double maxDescubiertoPermitido) {
        this.maxDescubiertoPermitido = maxDescubiertoPermitido;
    }

    /**
     * Devuelve la comisión fija por cada descubierto de la cuenta corriente de
     * la Empresa.
     *
     * @return double.
     */
    public double getComisionFijaPorDescubierto() {
        return comisionFijaPorDescubierto;
    }

    /**
     * Actualiza la comisión fija por cada descubierto.
     *
     * @param comisionFijaPorDescubierto
     */
    public void setComisionFijaPorDescubierto(double comisionFijaPorDescubierto) {
        this.comisionFijaPorDescubierto = comisionFijaPorDescubierto;
    }

    /**
     * Sobrescribe el método de la interfaz Imprimible que heredamos de la clase
     * padre con los datos de la cuenta corriente de empresa.
     *
     * @return
     */
    @Override
    public String devolverInfoString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CuentaCorrienteEmpresa{").append(titular.devolverInfoString());
        sb.append(", numeroCuenta=").append(numeroCuenta);
        sb.append(", saldo=").append(saldo);
        sb.append(" [ ");
        sb.append("entidadesAutorizadas=").append(entidadesAutorizadas);
        sb.append(", tipoInteresDescubierto=").append(tipoInteresDescubierto);
        sb.append(", maxDescubiertoPermitido=").append(maxDescubiertoPermitido);
        sb.append(", comisionFijaPorDescubierto=").append(comisionFijaPorDescubierto);
        sb.append(" ]");
        sb.append('}');
        return sb.toString();
    }
}
