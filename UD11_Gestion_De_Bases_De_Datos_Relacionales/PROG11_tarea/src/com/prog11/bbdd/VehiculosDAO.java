/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prog11.bbdd;

import static com.prog11.bbdd.PropietariosDAO.existPropietario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Manuel
 *
 * Clase con métodos estáticos, para poder llamar a los métodos sin la necesidad
 * de instancias la clase.
 */
public class VehiculosDAO {

    // Constantes que hacen relación a la tabla y a los campos de la base de datos.
    private static final String TABLE = "VEHICULOS";
    private static final String COL1 = "MAT_VEH";
    private static final String COL2 = "MARCA_VEH";
    private static final String COL3 = "KMS_VEH";
    private static final String COL4 = "PRECIO_VEH";
    private static final String COL5 = "DESC_VEH";
    private static final String COL6 = "ID_PROP";

    /**
     * Método para insertar un vehículo en la base de datos.
     *
     * @param matricula
     * @param marca
     * @param kms
     * @param precio
     * @param desc
     * @param idPropietario
     * @param con
     * @return 0 si está insertado y -1 si no está insertado.
     */
    public static int insertVehiculo(String matricula, String marca, int kms, float precio, String desc, int idPropietario, Connection con) {
        // Tipo de sentencia PreparedStatement para realizar sentencias SQL con parámetros.
        PreparedStatement ps;
        // Sentencia SQL para insertar un vehículo en la base de datos.
        String insert = "INSERT INTO " + TABLE
                + " (" + COL1 + ", " + COL2 + ", " + COL3 + ", " + COL4 + ", " + COL5 + ", " + COL6 + ")"
                + " VALUES (?,?,?,?,?,?);";
        try {
            if (existPropietario(idPropietario, con) && !existVehiculo(matricula, con)) {
                // Preparamos la consulta y la ejecutamos.                     
                ps = con.prepareStatement(insert);
                ps.setString(1, matricula);
                ps.setString(2, marca);
                ps.setInt(3, kms);
                ps.setFloat(4, precio);
                ps.setString(5, desc);
                ps.setInt(6, idPropietario);
                ps.executeUpdate();
                // Cerramos el PreparedStatement.
                ps.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        if (existVehiculo(matricula, con)) {
            return 0;
        } else {
            return -1;
        }
    }

    /**
     * Método para actualizar el propietario de un vehículo.
     *
     * @param matricula
     * @param idPropietario
     * @param con
     * @return 0 si está actualizado y -1 si no está actualizado.
     */
    public static int updateVehiculo(String matricula, int idPropietario, Connection con) {
        PreparedStatement ps;
        // Sentencia SQL para actualizar el propietario de un vehículo donde la mat_veh sea igual al parámetro matrícula.
        String update = "UPDATE " + TABLE
                + " SET " + COL6 + " = ?"
                + " WHERE " + COL1 + " = ?;";
        try {
            if (existVehiculo(matricula, con) && existPropietario(idPropietario, con)) {
                // Preparamos la consulta y la ejecutamos.                     
                ps = con.prepareStatement(update);
                ps.setInt(1, idPropietario);
                ps.setString(2, matricula);              
                ps.executeUpdate();
                // Cerramos el PreparedStatement.
                ps.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        if (existVehiculo(matricula, idPropietario, con)) {
            return 0;
        } else {
            return -1;
        }
    }

    /**
     * Método para eliminar un vehículos cuyo campo mat_veh se corresponda con
     * el parámetro matricula.
     *
     * @param matricula
     * @param con
     * @return El número de registros eliminados.
     */
    public static int deleteVehiculo(String matricula, Connection con) {
        int numRegDel = 0;
        PreparedStatement ps;
        // Sentencia SQL para eliminar vehículos en la bd donde le campo mat_veh sea igual al parámetro matrícula.
        String delete = "DELETE FROM " + TABLE
                + " WHERE " + COL1 + " = ?;";
        try {
            // Preparamos la consulta y la ejecutamos
            // Informamos del número de registros borrados 
            ps = con.prepareStatement(delete);
            ps.setString(1, matricula);
            numRegDel = ps.executeUpdate();
            // Cerramos el PreparedStatement.      
            ps.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return numRegDel;
    }

    /**
     * Método para obtener una lista de los vehículos de la base de datos.
     *
     * @param con
     * @return Una lista de los vehículos de la bd o null si no hay vehículos.
     */
    public static ArrayList<String> getVehiculos(Connection con) {
        // Lista para almacenar los vehículos.
        ArrayList<String> listVehiculos = new ArrayList<>();
        Statement s;
        ResultSet rs = null;
        // Sentencia SQL para obtener todos los datos de la tabla.
        String query = "SELECT * FROM " + TABLE + ";";
        try {
            // Preparamos la consulta
            s = con.createStatement();
            rs = s.executeQuery(query);
            // Iteramos sobre los registros del resultado
            while (rs.next()) {
                listVehiculos.add(rs.getString(COL1) + ", " + rs.getString(COL2) + ", " + rs.getInt(COL3) + ", " + rs.getFloat(COL4) + ", " + rs.getString(COL5) + ", " + rs.getInt(COL6));
            }
            // Cerramos el ResultSet
            rs.close();
            // Cerramos el Statement
            s.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        if (listVehiculos.size() > 0) {
            return listVehiculos;
        } else {
            return null;
        }
    }

    /**
     * Método para obtener una lista de vehículos de la base de datos donde el
     * campo marca_veh se corresponda con el parámetro marca.
     *
     * @param marca
     * @param con
     * @return Una lista de los vehículos de la marca indicada o null si no hay
     * vehículos de la marca.
     */
    public static ArrayList<String> getVehiculos(String marca, Connection con) {
        ArrayList<String> listVehiculos = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs = null;
        // Sentencia SQL para obtener todos los registros que se correspondan con la marca indicada en los parámetros.
        String query = "SELECT * FROM " + TABLE + " WHERE " + COL2 + " = ?;";
        try {
            // Preparamos la consulta
            ps = con.prepareStatement(query);
            ps.setString(1, marca);
            rs = ps.executeQuery();
            // Iteramos sobre los registros del resultado
            while (rs.next()) {
                listVehiculos.add(rs.getString(COL1) + ", " + rs.getString(COL2) + ", " + rs.getInt(COL3) + ", " + rs.getFloat(COL4) + ", " + rs.getString(COL5) + ", " + rs.getInt(COL6));
            }
            // Cerramos el ResultSet
            rs.close();
            // Cerramos el PreparedStatement
            ps.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        if (listVehiculos.size() > 0) {
            return listVehiculos;
        } else {
            return null;
        }
    }

    /**
     * Método para obtener una lista de vehículos de la base de datos donde el
     * campo id_prop se corresponda con el parámetro idPropietario.
     *
     * @param idPropietario
     * @param con
     * @return Una lista de los vehículos del propietario indicado o null si el
     * propietario no tiene vehículos.
     */
    public static ArrayList<String> getVehiculos(int idPropietario, Connection con) {
        ArrayList<String> listVehiculos = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs = null;
        // Sentencia SQL para obtener los vehículos de un propietario.
        String query = "SELECT * FROM " + TABLE + " WHERE " + COL6 + " = ?;";
        try {
            //Preparamos la consulta
            ps = con.prepareStatement(query);
            ps.setInt(1, idPropietario);
            rs = ps.executeQuery();
            // Iteramos sobre los registros del resultado
            while (rs.next()) {
                listVehiculos.add(rs.getString(COL1) + ", " + rs.getString(COL2) + ", " + rs.getInt(COL3) + ", " + rs.getFloat(COL4));
            }
            // Cerramos el ResultSet
            rs.close();
            // Cerramos el PreparedStatement
            ps.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        if (listVehiculos.size() > 0) {
            return listVehiculos;
        } else {
            return null;
        }
    }

    /**
     * Método para comprobar si hay una determinada matrícula insertada en la
     * base de datos.
     *
     * @param matricula
     * @param con
     * @return True si la matrícula ya está en la base de datos o False si
     * no está.
     */
    public static boolean existVehiculo(String matricula, Connection con) {
        boolean exist = false;
        PreparedStatement ps;
        ResultSet rs;
        // Sentencia SQL para comprobar si la matrícula de los parámetros del método está en la base de datos.
        String query = "SELECT * FROM " + TABLE + " WHERE " + COL1 + " = ?;";
        try {
            // Ejecuta la consulta
            ps = con.prepareStatement(query);
            ps.setString(1, matricula);
            rs = ps.executeQuery();
            // Procesa los resultados
            exist = rs.next();
            // Cerrar ResultSet
            rs.close();
            // Cerrar PreparedStatement
            ps.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return exist;
    }

    /**
     * Método para comprobar si hay una determinada matrícula con un idPropietario concreto está insertada en la
     * base de datos.
     * @param matricula
     * @param idPropietario
     * @param con
     * @return True si la matrícula con el idPropietario concreto ya está en la base de datos o False si
     * no está.
     */
    public static boolean existVehiculo(String matricula, int idPropietario, Connection con) {
        boolean exist = false;
        PreparedStatement ps;
        ResultSet rs;
        // Sentencia SQL para comprobar si la matrícula y el idPropietario de los parámetros del método está en la base de datos.
        String query = "SELECT * FROM " + TABLE + " WHERE " + COL1 + " = ? AND " + COL6 + " = ?;";
        try {
            // Ejecuta la consulta
            ps = con.prepareStatement(query);
            ps.setString(1, matricula);
            ps.setInt(2, idPropietario);
            rs = ps.executeQuery();
            // Procesa los resultados
            exist = rs.next();
            // Cerrar ResultSet
            rs.close();
            // Cerrar PreparedStatement
            ps.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return exist;
    }

}
