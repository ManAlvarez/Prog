/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Banco;

import java.util.ArrayList;

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

    public ArrayList<String> getListaEntidades() {
        return listaEntidades;
    }

    public void setListaEntidades(ArrayList<String> listaEntidades) {
        this.listaEntidades = listaEntidades;
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
