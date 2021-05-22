/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prog11.princ;

import java.sql.Connection;
import com.prog11.bbdd.ConnectionDB;
import com.prog11.bbdd.PropietariosDAO;
import com.prog11.bbdd.VehiculosDAO;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Manuel
 */
public class Prog11_Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        // Abrir conexión.
        Connection con = ConnectionDB.openConnection();

        ArrayList<String> listaVehiculos;

        // Insertar varios propietarios.
        System.out.println("Prueba: Insertar varios propietarios.");
        
        if (PropietariosDAO.insertPropietario("Juan", "11111111A", con) == 0) {
            System.out.println("El propietario ha sido insertado con éxito.");
        } else {
            System.out.println("El propietario no se ha podido insertar.");
        }     

        if (PropietariosDAO.insertPropietario("Jose", "22222222B", con) == 0) {
            System.out.println("El propietario ha sido insertado con éxito.");
        } else {
            System.out.println("El propietario no se ha podido insertar.");
        }
        
        if (PropietariosDAO.insertPropietario("Luis", "33333333C", con) == 0) {
            System.out.println("El propietario ha sido insertado con éxito.");
        } else {
            System.out.println("El propietario no se ha podido insertar.");
        }
        
        pulsarTecla();
        
        // Insertar varios vehículos.
        System.out.println("Prueba: Insertar varios vehículos.");
        
        if (VehiculosDAO.insertVehiculo("1111BBB", "Renault", 80, 12800.99f, "Azul y con cinco puertas", PropietariosDAO.getIdPropietario("11111111A", con), con) == 0) {
            System.out.println("El vehículo ha sido insertado con éxito.");
        } else {
            System.out.println("El vehículo no se ha podido insertar.");
        }

        if (VehiculosDAO.insertVehiculo("2222CCC", "Opel", 120, 15259.06f, "Blanco con techo solar", PropietariosDAO.getIdPropietario("22222222B", con), con) == 0) {
            System.out.println("El vehículo ha sido insertado con éxito.");
        } else {
            System.out.println("El vehículo no se ha podido insertar.");
        }
        
        if (VehiculosDAO.insertVehiculo("3333DDD", "Seat", 150, 18125, "Negro con llantas 16", PropietariosDAO.getIdPropietario("33333333C", con), con) == 0) {
            System.out.println("El vehículo ha sido insertado con éxito.");
        } else {
            System.out.println("El vehículo no se ha podido insertar.");
        }
        
        if (VehiculosDAO.insertVehiculo("4444FFF", "Toyota", 180, 21450.75f, "Rojo y hibrido", PropietariosDAO.getIdPropietario("33333333C", con), con) == 0) {
            System.out.println("El vehículo ha sido insertado con éxito.");
        } else {
            System.out.println("El vehículo no se ha podido insertar.");
        }
        
        if (VehiculosDAO.insertVehiculo("5555GGG", "Seat", 180, 16433, "Rojo y diesel", PropietariosDAO.getIdPropietario("33333333C", con), con) == 0) {
            System.out.println("El vehículo ha sido insertado con éxito.");
        } else {
            System.out.println("El vehículo no se ha podido insertar.");
        }

        pulsarTecla();
        
        // Actualizar propietario de un vehiculo.
        System.out.println("Prueba: Actualizar propietario de un vehiculo.");
        
        if(VehiculosDAO.updateVehiculo("4444FFF", PropietariosDAO.getIdPropietario("22222222B", con), con) == 0){
            System.out.println("El propietario del vehículo se ha actualizado con éxito.");
        }else{
            System.out.println("El propietario del vehículo no se ha actualizado.");
        }
        
        pulsarTecla();
        
        // Listar todos los vehiculos.        
        System.out.println("Prueba: Listar todos los vehiculos.");
        
        listaVehiculos = VehiculosDAO.getVehiculos(con);
        if (listaVehiculos != null) {
            for (String vehiculo : listaVehiculos) {
                System.out.println(vehiculo);
            }
        } else {
            System.out.println("No hay vehículos.");
        }
        
        pulsarTecla();

        // Eliminar un vehículo que exista.       
        System.out.println("Prueba: Eliminar un vehículo que exista.");
        
        if (VehiculosDAO.deleteVehiculo("1111BBB", con) > 0) {
            System.out.println("El vehículo ha sido eliminado con éxito.");
        } else {
            System.out.println("El vehículo no se ha podido eliminar.");
        }
        
        pulsarTecla();

        // Eliminar un vehículo que no exista.       
        System.out.println("Prueba: Eliminar un vehículo que no exista.");
        
        if (VehiculosDAO.deleteVehiculo("1111BBB", con) > 0) {
            System.out.println("El vehículo ha sido eliminado con éxito.");
        } else {
            System.out.println("El vehículo no se ha podido eliminar.");
        }
        
        pulsarTecla();

        // Listar todos los vehículos.       
        System.out.println("Prueba: Listar todos los vehículos.");
        
        listaVehiculos = VehiculosDAO.getVehiculos(con);
        if (listaVehiculos != null) {
            for (String vehiculo : listaVehiculos) {
                System.out.println(vehiculo);
            }
        } else {
            System.out.println("No hay vehículos.");
        }
        
        pulsarTecla();

        // Listar los vehículos de una marca.        
        System.out.println("Prueba: Listar los vehículos de una marca.");
        
        listaVehiculos = VehiculosDAO.getVehiculos("Seat", con);
        if (listaVehiculos != null) {
            for (String vehiculo : listaVehiculos) {
                System.out.println(vehiculo);
            }
        } else {
            System.out.println("No hay vehículos de la marca indicada.");
        }
        
        pulsarTecla();

        // Listar todos los vehículos de un propietario.       
        System.out.println("Prueba: Listar todos los vehículos de un propietario.");
        
        listaVehiculos = PropietariosDAO.getVehiculosPropietario("22222222B", con);
        if (listaVehiculos != null) {
            for (String vehiculo : listaVehiculos) {
                System.out.println(vehiculo);
            }
        } else {
            System.out.println("El propietario indicado no tiene vehículos.");
        }
        
        pulsarTecla();

        // Eliminar un propietario con vehiculos.       
        System.out.println("Prueba: Eliminar un propietario con vehiculos.");
        
        if (PropietariosDAO.getVehiculosPropietario("22222222B", con) != null) {
            if (PropietariosDAO.deletePropietario("22222222B", con) > 0) {
                System.out.println("Se ha eliminado el propietario indicado.");
            } else {
                System.out.println("No se ha eliminado el propietario.");
            }
        } else {
            System.out.println("No se ha eliminado el propietario indicado porque no tiene vehículos o no éxiste.");
        }
        
        pulsarTecla();

        // Eliminar un propietario sin vehiculos.       
        System.out.println("Prueba: Eliminar un propietario sin vehiculos.");
        
        if (PropietariosDAO.getVehiculosPropietario("11111111A", con) == null) {
            if (PropietariosDAO.deletePropietario("11111111A", con) > 0) {
                System.out.println("Se ha eliminado el propietario indicado.");
            } else {
                System.out.println("No se ha eliminado el propietario.");
            }
        } else {
            System.out.println("No se ha eliminado el propietario indicado porque tiene vehículos.");
        }

        // Cerrar conexión.
        ConnectionDB.closeConnection();

    }
    
    // Método para ir revisando las pruebas.
    public static void pulsarTecla(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Pulsa una tecla para continuar con la siguiente prueba.");
        sc.nextLine();
    }

}
