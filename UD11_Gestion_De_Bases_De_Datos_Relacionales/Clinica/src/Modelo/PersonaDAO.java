/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.DefaultListModel;

/**
 *
 * @author Manuel
 */
public class PersonaDAO{

    private static Connection con;
    private static final String PERSONA = "persona";
    private static final String ID_PERSONA = "id_persona";
    private static final String NOMBRE = "nombre";
    private static final String APELLIDOS = "apellidos";

    public static void insertPersona(int idPersona, String nombre, String apellidos) {
        try {
            con = Conexion.openConnection();
            String insert = "INSERT INTO " + PERSONA + " (" + ID_PERSONA + ", " + NOMBRE + ", " + APELLIDOS + ") " + "VALUES(?, ?, ?);";
            PreparedStatement ps = con.prepareStatement(insert);
            ps.setInt(1, idPersona);
            ps.setString(2, nombre);
            ps.setString(3, apellidos);
            ps.executeUpdate();
            ps.close();
            Conexion.closeConnection(con);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void actualizarPersona(int idPersona, String nombre, String apellidos) {
        try {
            con = Conexion.openConnection();
            String update = "UPDATE " + PERSONA + " SET " + NOMBRE + " = ?, " + APELLIDOS + " = ? WHERE " + ID_PERSONA + " = ?;";
            PreparedStatement ps = con.prepareStatement(update);
            ps.setString(1, nombre);
            ps.setString(2, apellidos);
            ps.setInt(3, idPersona);
            ps.executeUpdate();
            ps.close();
            Conexion.closeConnection(con);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public static boolean existePersona(int idPersona) {
        boolean existe = false;
        try {
            con = Conexion.openConnection();
            String query = "SELECT " + ID_PERSONA + " FROM " + PERSONA + " WHERE " + ID_PERSONA + " = ?;";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, idPersona);
            ResultSet rs = ps.executeQuery();
            existe = rs.next();
            rs.close();
            ps.close();
            Conexion.closeConnection(con);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return existe;
    }

    public static int deletePersona(int idPersona) {
        int numReg = 0;
        try {
            con = Conexion.openConnection();
            String delete = "DELETE FROM " + PERSONA + " WHERE " + ID_PERSONA + " = ?;";
            PreparedStatement ps = con.prepareStatement(delete);
            ps.setInt(1, idPersona);
            numReg = ps.executeUpdate();
            ps.close();
            Conexion.closeConnection(con);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return numReg;
    }

    public static DefaultListModel listarPersonas() {
        DefaultListModel personas = new DefaultListModel();
        try {
            con = Conexion.openConnection();
            String query = "SELECT * FROM " + PERSONA + ";";
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(query);
            while (rs.next()) {
                personas.addElement(rs.getInt(ID_PERSONA)+", "+rs.getString(NOMBRE)+", "+rs.getString(APELLIDOS));
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return personas;
    }
    
    public static ArrayList<Persona> listarPersonas2() {

        ArrayList<Persona> personas = new ArrayList<>();
        try {
            con = Conexion.openConnection();
            String query = "SELECT * FROM " + PERSONA + ";";
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(query);
            while (rs.next()) {          
                personas.add(new Persona(rs.getInt(ID_PERSONA),rs.getString(NOMBRE),rs.getString(APELLIDOS)));
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return personas;
    }

}
