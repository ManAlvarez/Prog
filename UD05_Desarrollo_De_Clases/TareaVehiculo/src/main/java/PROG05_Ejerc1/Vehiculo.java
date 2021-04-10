package PROG05_Ejerc1;

import java.time.LocalDate;
import java.time.Period;

/**
 * Representa un vehículo.
 *
 * @author
 * @version 1.0
 */
public class Vehiculo {
    private String marca;
    private String matricula;
    private int numKM;
    private LocalDate fechMatricula;
    private String descripcion;
    private double precio;
    private String nomPropietario;
    private String dniPropietario;

    /**
     * Constructor
     *
     * @param marca marca o fabricante del vehículo.
     * @param matricula matrícula del vehículo.
     * @param numKM kilometraje actual del vehuclo.
     * @param fechaMatricula fecha de matriculación del vehículo.
     * @param descricpción modelo, motorización y descripción del vehículo.
     * @param precio precio venta del vehículo.
     * @param nomPropietario nombre del propietario.
     * @param dniPropietario DNI del propietario.
     */
    Vehiculo(String marca, String matricula, int numKM, LocalDate fechMatricula, String descripcion,
        double precio, String nomPropietario, String dniPropietario) {
        this.marca = marca;
        this.matricula = matricula;
        this.numKM = numKM;
        this.fechMatricula = fechMatricula;
        this.descripcion = descripcion;
        this.precio = precio;
        this.nomPropietario = nomPropietario;
        this.dniPropietario = dniPropietario;
    }

    /** Devuelve la marca del vehículo. */
    public String get_Marca() {
        return this.marca;
    }

    /** Devuelve la matrícula. */
    public String get_Matricula() {
        return this.matricula;
    }

    /** Devuelve el kilometraje actual. */
    public int get_NumKM() {
        return this.numKM;
    }

    /**
     * Actualiza el kilometraje actual.
     * @param numKM nuevo valor del kilometraje.
     * */
    public void set_NumKM(int numKM) {
        this.numKM = numKM;
    }

    /** Devuelve la fecha de matriculación. */
    public LocalDate get_FechMatricula() {
        return this.fechMatricula;
    }

    /** Devuelve la descripción. */
    public String get_Descripcion() {
        return this.descripcion;
    }

    /** Devuelve el precio. */
    public double get_Precio() {
        return this.precio;
    }

    /** Devuelve el nombre del propietario. */
    public String get_NomPropietario() {
        return this.nomPropietario;
    }

    /** Devuelve el DNI del propietario. */
    public String get_DNIPropietario() {
        return this.dniPropietario;
    }

    /**
     * Devuelve la edad del vehículo en años.
     *
     * @return años completos transcurridos desde la matriculación hasta la fecha actual.
     * */
    public int get_Anios(Vehiculo v) {
        return Period.between(v.get_FechMatricula(), LocalDate.now()).getYears();
    }
}
