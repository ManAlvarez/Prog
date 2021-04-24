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
 * subclase el mismo paquete y desde otro paquete que hereda de la clase Cuenta
 * Bancaria todos los atributos y métodos.
 *
 */
public abstract class CuentaCorriente extends CuentaBancaria implements Serializable {

    // Atributo declarado como protected, no es accesibles desde otro paquete.
    protected String entidadesAutorizadas;

}
