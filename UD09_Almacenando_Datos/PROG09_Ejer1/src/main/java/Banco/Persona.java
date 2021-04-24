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
 * que implementa la interfaz Imprimible y sus métodos.
 */
public class Persona implements Imprimible, Serializable {

    //Atributos encapsulados de la clase.
    private String nombre;
    private String apellidos;
    private String DNI;

    /**
     * Constructor de la clase.
     *
     * @param nombre
     * @param apellidos
     * @param DNI
     */
    public Persona(String nombre, String apellidos, String DNI) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.DNI = DNI;
    }

    /**
     * Devuelve el nombre de la persona.
     *
     * @return String.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Actualiza el nombre.
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve los apellidos de la persona.
     *
     * @return String.
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * Actualiza los apellidos.
     *
     * @param apellidos
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * Devulve el DNI de la persona.
     *
     * @return String.
     */
    public String getDNI() {
        return DNI;
    }

    /**
     * Actualiza el DNI.
     *
     * @param DNI
     */
    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    /**
     * Sobrescribe el método de la interfaz con los datos de la persona.
     *
     * @return String.
     */
    @Override
    public String devolverInfoString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Persona{nombre=").append(nombre);
        sb.append(", apellidos=").append(apellidos);
        sb.append(", DNI=").append(DNI);
        sb.append('}');
        return sb.toString();
    }

}
