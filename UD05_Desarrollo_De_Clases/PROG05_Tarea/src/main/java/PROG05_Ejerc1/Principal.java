package PROG05_Ejerc1;

import PROG05_Ejerc1_util.Herramienta;
import java.time.DateTimeException;
import java.time.LocalDate;

/**
 *
 * @author Manuel
 * Clase publica, en ella interaccionamos con el resto de las clases.
 */
public class Principal {
    
    private static Vehiculo nuevoVehiculo = null; // Atributo de la clase.
    
    /**
     * Método princiapal, es desde donde se inicia la aplicación.
     * Es un método público para que sea accedible desde fuera de la clase y estático para que se pueda ejecutar sin una instancia de la clase.
     * @param args 
     */
    public static void main(String[] args) {
        accionMenu(menu()); //Llamamos a método accionMenu() y le pasamos como parámetro el valor devuelto por el método menu().
    }

    /**
     * Método que muestra un menú por consola, en el cual debemos seleccionar una opción,
     * hasta que no seleccionemos un opción correcta se seguirá mostrando.
     * Es un método privado para que no sea accedible desde fuera de la clase y estático para que se pueda ejecutar sin una instancia de la clase.
     * @return int
     */
    private static int menu() {
        int op = -1;
        while (true) {
            Herramienta.limpiarConsola(30);
            System.out.println("1.  Nuevo Vehiculo.");
            System.out.println("2.  Ver Matricula.");
            System.out.println("3.  Ver Número de Kilómetros.");
            System.out.println("4.  Actualizar Kilometros.");
            System.out.println("5.  Ver años de antigüedad.");
            System.out.println("6.  Mostrar propietario.");
            System.out.println("7.  Mostrar descripción.");
            System.out.println("8.  Mostrar Precio.");
            System.out.println("9.  Salir");
            System.out.println("Selecciona una opción: ");
            op = Herramienta.insertarNumero();
            Herramienta.limpiarConsola(30);
            if (op != -1 && op >= 1 && op <= 9) {
                break;
            }
        }
        return op;
    }
    
    /**
     * Método para realizar las acciones seleccionadas en el menú, sependiendo de la opción seleccionada.
     * Es un método privado para que no sea accedible desde fuera de la clase y estático para que se pueda ejecutar sin una instancia de la clase.
     * @param opcion 
     */
    private static void accionMenu(int opcion){
        switch(opcion){
            case 1:
                if(!addVehiculo()) accionMenu(menu()); // Si el método addVehiculo() devuelve un false.
                Herramienta.pulsarEnter(); //LLamamos a el método pulsarEnter() de la clase Herramientas.
                accionMenu(menu());
                break;
            case 2:
                if(nuevoVehiculo == null) System.out.println("Error No hay ningún vehiculo."); // Comprobamos si hay algún vehiculo.
                else System.out.println("Matrícula: "+nuevoVehiculo.getMatricula());
                Herramienta.pulsarEnter(); 
                accionMenu(menu());
                break;
            case 3:
                if(nuevoVehiculo == null) System.out.println("Error No hay ningún vehiculo.");
                else System.out.println("Número de Kms: "+nuevoVehiculo.getNumeroKm()); 
                Herramienta.pulsarEnter(); 
                accionMenu(menu());
                break;
            case 4:
                if(nuevoVehiculo == null) System.out.println("Error No hay ningún vehiculo.");
                else {   
                    int km = -1;
                    while(km < 0) {
                        System.out.println("Inserta el número de Km que desea añadir a los kms del vehiculo:");
                        km = Herramienta.insertarNumero();                     
                    }
                    nuevoVehiculo.actualizarKm(km);
                    System.out.println("Kms actualizados correctamente.");
                }
                Herramienta.pulsarEnter();
                accionMenu(menu());
                break;
            case 5:
                if(nuevoVehiculo == null) System.out.println("Error No hay ningún vehiculo.");
                else System.out.println("Años del Vehiculo: "+nuevoVehiculo.get_Anios());
                Herramienta.pulsarEnter();
                accionMenu(menu());
                break;
            case 6:
                if(nuevoVehiculo == null) System.out.println("Error No hay ningún vehiculo.");
                else {
                    System.out.println("Nombre del Propietario: "+nuevoVehiculo.getNombrePropietario());
                    System.out.println("DNI del Propietario: "+nuevoVehiculo.getDniPropietario());
                }
                Herramienta.pulsarEnter();
                accionMenu(menu());
                break;
            case 7:
                if(nuevoVehiculo == null) System.out.println("Error No hay ningún vehiculo.");
                else {
                    System.out.println("Descripción del Vehiculo: "+nuevoVehiculo.getDescripcion());
                    System.out.println("Matrícula: "+nuevoVehiculo.getMatricula());
                    System.err.println("Número de Kms: "+nuevoVehiculo.getNumeroKm());
                }
                Herramienta.pulsarEnter(); 
                accionMenu(menu());
                break;
            case 8:
                if(nuevoVehiculo == null) System.out.println("Error No hay ningún vehiculo.");
                else System.out.println("Precio: "+nuevoVehiculo.getPrecio());
                Herramienta.pulsarEnter(); 
                accionMenu(menu());
                break;
            case 9:
                System.exit(0);
                break;
            default:
                break;
        }
    }
    
    /**
     * Método para crear una fecha indicando el día, mes y año.
     * Es un método privado para que no sea accedible desde fuera de la clase y estático para que se pueda ejecutar sin una instancia de la clase.
     * @return LocalDate
     */
    private static LocalDate fecha(){
        
        LocalDate localDate = null;
        
        System.out.println("Inserta el día:");
        int dia = Herramienta.insertarNumero();
        
        System.out.println("Inserta el mes:");
        int mes = Herramienta.insertarNumero();
        
        System.out.println("Inserta el año:");
        int anho = Herramienta.insertarNumero();
        
        try {
            localDate = LocalDate.of(anho, mes, dia);
        } catch (DateTimeException e) {
            System.out.println("Fecha incorrecta.");
        }    
        
        return localDate;
    }
    
    /**
     * Método para inicializar el estado del objeto nuevoVehiculo.
     * Es un método privado para que no sea accedible desde fuera de la clase y estático para que se pueda ejecutar sin una instancia de la clase.
     * @return boolean
     */
    private static boolean addVehiculo(){
        
        nuevoVehiculo = null; // inicializamos la variable de la clase.
        
        //Variables del método.
        String marca, matricula, descripcion, nombrePropietario, dniPropietario = null;
        int numeroKilometros = -1;
        double precio = -1;
        LocalDate fechaActual = LocalDate.now(), fechaMatriculacion = null;
        
        System.out.println("Inserta la marca del vehiculo:");
        marca = Herramienta.insertarCadena();
        Herramienta.limpiarConsola(30);

        System.out.println("Inserta la matrícula del vehiculo:");
        matricula = Herramienta.insertarCadena().toUpperCase();
        Herramienta.limpiarConsola(30);
     
        while(numeroKilometros < 0) {
            System.out.println("Inserta el número de kilómetros que tiene el vehiculo:"); 
            numeroKilometros = Herramienta.insertarNumero();
        }
        Herramienta.limpiarConsola(30);
        
        while(fechaMatriculacion == null || !fechaMatriculacion.isBefore(fechaActual)){
            System.out.println("Inserta la fecha de matriculación del vehiculo:");
            fechaMatriculacion = fecha();
        }
        Herramienta.limpiarConsola(30);
        
        System.err.println("Inserta la descripción del vehiculo:");
        descripcion = Herramienta.insertarCadena();
        Herramienta.limpiarConsola(30);
  
        while(precio < 0){
            System.out.println("Inserta el precio del vehiculo:");
            precio = Herramienta.insertarNumeroDecimal();
        }
        Herramienta.limpiarConsola(30);
        
        System.out.println("Inserta el nombre del propietario del vehiculo:");
        nombrePropietario = Herramienta.insertarCadena();
        Herramienta.limpiarConsola(30);
 
        while(dniPropietario == null || !Herramienta.validarDni(dniPropietario)){
            System.out.println("Inserta el dni del propietario del vehiculo:");
            dniPropietario = Herramienta.insertarCadena().toUpperCase();
        }
        Herramienta.limpiarConsola(30);
        //Instanciamos la clase y inicializamos todos los atributos del objeto nuevoVehiculo.
        nuevoVehiculo = new Vehiculo(marca, matricula, numeroKilometros, fechaMatriculacion, descripcion, precio, nombrePropietario, dniPropietario);
        System.out.println("Vehiculo añadido con éxito.");
        return true;
    }

}
