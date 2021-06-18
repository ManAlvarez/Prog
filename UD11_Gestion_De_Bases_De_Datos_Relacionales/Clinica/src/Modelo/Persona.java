/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;

/**
 *
 * @author Manuel
 */
public class Persona implements Serializable {

    private static final long serialVersionUID = 2444287794772163146L;

    private int idPersona;
    private String nombre;
    private String apellidos;

    public Persona(int idPersona, String nombre, String apellidos) {
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

}
