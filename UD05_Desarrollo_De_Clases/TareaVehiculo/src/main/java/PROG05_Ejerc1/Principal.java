package PROG05_Ejerc1;

import PROG05_Ejerc1.Vehiculo;
import PROG05_Ejerc1_util.Util;
import java.time.LocalDate;
import java.util.Scanner;

/**
 * Aplicación para la gestión de vehículos.
 *
 * @author
 * @version 1.0
 */
public class Principal {
    /** Opciones del menú principal. */
    private static final int OPC_NUEVO = 1;
    private static final int OPC_VER_MAT = 2;
    private static final int OPC_VER_KM = 3;
    private static final int OPC_ACT_KM = 4;
    private static final int OPC_VER_ANIO = 5;
    private static final int OPC_VER_PROP = 6;
    private static final int OPC_VER_DESC = 7;
    private static final int OPC_VER_PREC = 8;
    private static final int OPC_SALIR = 9;

    /**
     * Solicita los datos para la creación de una nueva instancia de vehiculo.
     *
     * @param cin objeto Scanner para la entrada de datos
     * @return nuevo objeto Vehiculo
     */
    private static Vehiculo opcNuevo(Scanner cin) {
        System.out.println("\n--> NUEVO VEHICULO");
        System.out.println("\nIntroduzca los siguientes datos del vehículo\n");

        // Marca
        System.out.print("Marca: ");
        String marca = cin.nextLine().trim();

        // Matrícula
        System.out.print("Matrícula: ");
        String matricula = cin.nextLine().trim();

        // Número de KMs
        System.out.print("Nº de kms: ");
        int numKM = Integer.parseInt(cin.nextLine().trim());
        if (!Util.validaKM(numKM)) {
            System.out.println("\n--> ERR: Kilometraje incorrecto");
            return null;
        }

        // Fecha de matriculación
        System.out.print("Fecha de matriculación [aaaa-mm-dd]: ");
        LocalDate fechMatricula = LocalDate.parse(cin.nextLine().trim());
        if (!Util.validaFechaMat(fechMatricula)) {
            System.out.println("\n--> ERR: Fecha de matriculación incorrecta");
            return null;
        }

        // Descripción
        System.out.print("Descripción: ");
        String descripcion = cin.nextLine().trim();

        // Precio
        System.out.print("Precio: ");
        Double precio = Double.parseDouble(cin.nextLine().trim());

        // Nombre propietario
        System.out.print("Nombre propietario: ");
        String nomPropietario = cin.nextLine().trim();

        // DNI propietario
        System.out.print("DNI propietario: ");
        String dniPropietario = cin.nextLine().trim();
        try {
            Util.validaDNI(dniPropietario);
        } catch (Exception e) {
            System.out.println("\n--> ERR: " + e.getMessage());
            return null;
        }

        return new Vehiculo(marca, matricula, numKM, fechMatricula, descripcion, precio,
            nomPropietario, dniPropietario);
    }

    /**
     * Actualiza la información de kilometraje del vehículo.
     *
     * @param v objeto Vehiculo a actualizar
     * @param cin objeto Scanner para la entrada de datos
     */
    private static void opcActualizaKM(Vehiculo v, Scanner cin) {
        System.out.println("\n--> ACTUALIZA KILOMETRAJE");
        System.out.print("\nNuevo kilometraje del vehículo: ");

        int km = Integer.parseInt(cin.nextLine());
        if (km <= v.get_NumKM())
            System.out.println(
                "\n--> ERR: El kilometraje indicado es inferior al actual del vehículo.");
        else
            v.set_NumKM(km);
    }

    /** Muestra el menú de opciones. */
    public static void showMenu() {
        System.out.println();
        System.out.println("********************************");
        System.out.println("*     GESTION DE VEHICULOS     *");
        System.out.println("********************************");
        System.out.println(" 1 - Nuevo Vehiculo");
        System.out.println(" 2 - Ver Matrícula");
        System.out.println(" 3 - Ver Número de Kilómetros");
        System.out.println(" 4 - Actualizar Kilómetros");
        System.out.println(" 5 - Ver Años de Antigüedad");
        System.out.println(" 6 - Mostrar Propietario");
        System.out.println(" 7 - Mostrar Descripción");
        System.out.println(" 8 - Mostrar Precio");
        System.out.println(" 9 - Salir");
        System.out.println();
    }

    /** Método principal */
    public static void main(String[] args) {
        Vehiculo veh = null; // Objeto Vehiculo principal

        Scanner cin = new Scanner(System.in);

        boolean exit = false;
        while (!exit) {
            // Mostramos el menú de opciones:
            showMenu();

            // Solicitamos la opción
            System.out.print("opc > ");
            int opc = Integer.parseInt(cin.nextLine().trim());

            switch (opc) {
                case OPC_NUEVO:
                    veh = opcNuevo(cin);
                    break;

                case OPC_VER_MAT:
                    if (veh != null)
                        System.out.println("\n--> MATRICULA: " + veh.get_Matricula());
                    else
                        System.out.println("\n--> ERR: Aún no se ha dado de alta el vehículo");
                    break;

                case OPC_VER_KM:
                    if (veh != null)
                        System.out.println("\n--> KILOMETRAJE: " + veh.get_NumKM());
                    else
                        System.out.println("\n--> ERR: Aún no se ha dado de alta el vehículo");
                    break;

                case OPC_ACT_KM:
                    if (veh != null)
                        opcActualizaKM(veh, cin);
                    else
                        System.out.println("\n--> ERR: Aún no se ha dado de alta el vehículo");
                    break;

                case OPC_VER_ANIO:
                    if (veh != null)
                        System.out.println("\n--> AÑOS: " + veh.get_Anios(veh));
                    else
                        System.out.println("\n--> ERR: Aún no se ha dado de alta el vehículo");
                    break;

                case OPC_VER_PROP:
                    if (veh != null)
                        System.out.println("\n--> PROPIETARIO: [" + veh.get_DNIPropietario() + "] "
                            + veh.get_NomPropietario());
                    else
                        System.out.println("\n--> ERR: Aún no se ha dado de alta el vehículo");
                    break;

                case OPC_VER_DESC:
                    if (veh != null)
                        System.out.println("\n--> DESCRIPCION: " + veh.get_Descripcion());
                    else
                        System.out.println("\n--> ERR: Aún no se ha dado de alta el vehículo");
                    break;

                case OPC_VER_PREC:
                    if (veh != null)
                        System.out.printf("\n--> PRECIO: %.2f€%n", veh.get_Precio());
                    else
                        System.out.println("\n--> ERR: Aún no se ha dado de alta el vehículo");
                    break;

                case OPC_SALIR:
                    exit = true;
                    break;

                default:
                    System.out.println("\n--> ERR: Opción no válida");
            }
        }
    }
}
