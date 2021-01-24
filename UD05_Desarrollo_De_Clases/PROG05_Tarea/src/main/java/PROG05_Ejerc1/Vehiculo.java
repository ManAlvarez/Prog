package PROG05_Ejerc1;

import java.time.LocalDate;
import java.time.Period;

/**
 *
 * @author Manuel
 * Clase vehiculo es una plantilla para crear objetos.
 * Es una clase con el modificador de acceso por defecto accesible solo en el mismo paquete, 
 * como la clase principal está en el mismo paquete y es la que realiza las instancias a esta 
 * clase no es necesario declararla como pública. 
 *
 */

class Vehiculo {
    
    //Atributos de objeto. Privados, solo son accesibles a través de los métodos getter y setter.
    private String marca;
    private String matricula;
    private int numeroKm;
    private LocalDate fechaMatriculacion;
    private String descripcion;
    private Double precio;
    private String nombrePropietario;
    private String dniPropietario;

    /**
     * Constructor sin parámetros, necesario para instanciar la clase.
     */
    public Vehiculo() {
    }

   /**
    * Constructor con todos los parámetros necesarios.
    * @param marca
    * @param matricula
    * @param numeroKm
    * @param fechaMatriculacion
    * @param descripcion
    * @param precio
    * @param nombrePropietario
    * @param dniPropietario 
    */
    public Vehiculo(String marca, String matricula, int numeroKm, LocalDate fechaMatriculacion, String descripcion, Double precio, String nombrePropietario, String dniPropietario) {
        this.marca = marca;
        this.matricula = matricula;
        this.numeroKm = numeroKm;
        this.fechaMatriculacion = fechaMatriculacion;
        this.descripcion = descripcion;
        this.precio = precio;
        this.nombrePropietario = nombrePropietario;
        this.dniPropietario = dniPropietario;
    }
    
    /**
     * Método para obtener la marca del vehiculo.
     * Es un método público para que sea accedible desde fuera de la clase y no es estático, por lo tanto es necesario una instancia de la clase.
     * @return String
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Método para dar valor a marca.
     * Es un método público para que sea accedible desde fuera de la clase y no es estático, por lo tanto es necesario una instancia de la clase.
     * @param marca 
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * Método para obtener la matrícula del vehiculo.
     * Es un método público para que sea accedible desde fuera de la clase y no es estático, por lo tanto es necesario una instancia de la clase.
     * @return String
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * Método para dar valor a matricula.
     * Es un método público para que sea accedible desde fuera de la clase y no es estático, por lo tanto es necesario una instancia de la clase.
     * @param matricula 
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    /**
     * Método para obtener el número de kms del vehiculo.
     * Es un método público para que sea accedible desde fuera de la clase y no es estático, por lo tanto es necesario una instancia de la clase.
     * @return int
     */
    public int getNumeroKm() {
        return numeroKm;
    }

    /**
     * Método para dar valor numeroKm.
     * Es un método público para que sea accedible desde fuera de la clase y no es estático, por lo tanto es necesario una instancia de la clase.
     * @param numeroKm 
     */
    public void setNumeroKm(int numeroKm) {
        this.numeroKm = numeroKm;
    }

    /**
     * Método para obtener la fecha de matriculación del vehiculo.
     * Es un método público para que sea accedible desde fuera de la clase y no es estático, por lo tanto es necesario una instancia de la clase.
     * @return LocalDate
     */
    public LocalDate getFechaMatriculacion() {
        return fechaMatriculacion;
    }

    /**
     * Método para dar valor a fechaMatriculacion.
     * Es un método público para que sea accedible desde fuera de la clase y no es estático, por lo tanto es necesario una instancia de la clase.
     * @param fechaMatriculacion 
     */
    public void setFechaMatriculacion(LocalDate fechaMatriculacion) {
        this.fechaMatriculacion = fechaMatriculacion;
    }

    /**
     * Método para obtener la descripción del vehiculo.
     * Es un método público para que sea accedible desde fuera de la clase y no es estático, por lo tanto es necesario una instancia de la clase.
     * @return String
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Método para dar valor a descripcion.
     * Es un método público para que sea accedible desde fuera de la clase y no es estático, por lo tanto es necesario una instancia de la clase.
     * @param descripcion 
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Método para obtener el precio del vehiculo.
     * Es un método público para que sea accedible desde fuera de la clase y no es estático, por lo tanto es necesario una instancia de la clase.
     * @return Double
     */
    public Double getPrecio() {
        return precio;
    }
    
    /**
     * Método para dar valor a precio.
     * Es un método público para que sea accedible desde fuera de la clase y no es estático, por lo tanto es necesario una instancia de la clase.
     * @param precio 
     */
    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    /**
     * Método para obtener el nombre del propietario del vehiculo.
     * Es un método público para que sea accedible desde fuera de la clase y no es estático, por lo tanto es necesario una instancia de la clase.
     * @return String
     */
    public String getNombrePropietario() {
        return nombrePropietario;
    }

    /**
     * Método para dar valor a nombrePropietario.
     * Es un método público para que sea accedible desde fuera de la clase y no es estático, por lo tanto es necesario una instancia de la clase.
     * @param nombrePropietario 
     */
    public void setNombrePropietario(String nombrePropietario) {
        this.nombrePropietario = nombrePropietario;
    }

    /**
     * Método para obtener el dni del propietario del vehiculo.
     * Es un método público para que sea accedible desde fuera de la clase y no es estático, por lo tanto es necesario una instancia de la clase.
     * @return String
     */
    public String getDniPropietario() {
        return dniPropietario;
    }

    /**
     * Método para dar valor a dniPropietario.
     * Es un método público para que sea accedible desde fuera de la clase y no es estático, por lo tanto es necesario una instancia de la clase.
     * @param dniPropietario 
     */
    public void setDniPropietario(String dniPropietario) {
        this.dniPropietario = dniPropietario;
    }
    
    /**
     * Método para actualizar el número de kms del vehiculo sumando a numeroKm a los kms indicados en el parámetro.
     * Es un método público para que sea accedible desde fuera de la clase y no es estático, por lo tanto es necesario una instancia de la clase.
     * @param km 
     */
    public void actualizarKm(int km){
        numeroKm += km;
    }
    
    /**
     * Método que nos devuelve el número de años que hay entre la fecha actual y la fecha de matriculación del vehiculo.
     * Es un método público para que sea accedible desde fuera de la clase y no es estático, por lo tanto es necesario una instancia de la clase.
     * @return int
     */
    public int get_Anios(){
        LocalDate fechaActual = LocalDate.now();
        int anios = Period.between(fechaMatriculacion, fechaActual).getYears();
        return anios;
    }
    
}
