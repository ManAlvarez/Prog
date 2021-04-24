/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Banco;

import java.io.Serializable;

/**
 *
 * @author Manuel Clase abstracta pública accesible desde la misma clase, una
 * subclase el mismo paquete y desde otro paquete que implementa la interfaz
 * Imprimible y contiene en su atributos un objeto de la clase Persona.
 */
public abstract class CuentaBancaria implements Imprimible, Serializable {

    // Atributos declarados como protected, no son accesibles desde otro paquete.
    protected Persona titular;
    protected double saldo;
    protected String numeroCuenta;

}
