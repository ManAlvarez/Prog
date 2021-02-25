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
public class CuentaCorrienteEmpresa extends CuentaCorriente {

    protected double tipoInteresDescubierto;
    protected double maxDescubiertoPermitido;
    protected double comisionFijaPorDescubierto;

    public CuentaCorrienteEmpresa() {
    }

    public double getTipoInteresDescubierto() {
        return tipoInteresDescubierto;
    }

    public void setTipoInteresDescubierto(double tipoInteresDescubierto) {
        this.tipoInteresDescubierto = tipoInteresDescubierto;
    }

    public double getMaxDescubiertoPermitido() {
        return maxDescubiertoPermitido;
    }

    public void setMaxDescubiertoPermitido(double maxDescubiertoPermitido) {
        this.maxDescubiertoPermitido = maxDescubiertoPermitido;
    }

    public double getComisionFijaPorDescubierto() {
        return comisionFijaPorDescubierto;
    }

    public void setComisionFijaPorDescubierto(double comisionFijaPorDescubierto) {
        this.comisionFijaPorDescubierto = comisionFijaPorDescubierto;
    }

    public String getEntidadesAutorizadas() {
        return entidadesAutorizadas;
    }

    public void setEntidadesAutorizadas(String entidadesAutorizadas) {
        this.entidadesAutorizadas = entidadesAutorizadas;
    }

    public Persona getTitular() {
        return titular;
    }

    public void setTitular(Persona titular) {
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    @Override
    public String devolverInfoString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CuentaCorrienteEmpresa{").append(titular.devolverInfoString());
        sb.append(", numeroCuenta=").append(numeroCuenta);
        sb.append(", saldo=").append(saldo);
        sb.append(", tipoInteresDescubierto=").append(tipoInteresDescubierto);
        sb.append(", maxDescubiertoPermitido=").append(maxDescubiertoPermitido);
        sb.append(", comisionFijaPorDescubierto=").append(comisionFijaPorDescubierto);
        sb.append('}');
        return sb.toString();
    }
}
