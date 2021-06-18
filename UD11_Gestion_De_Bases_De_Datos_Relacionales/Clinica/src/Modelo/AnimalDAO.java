/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Manuel
 */
public class AnimalDAO {

    private static Connection con;

    private static final String ANIMAL = "animal";
    private static final String ID_ANIMAL = "id_animal";
    private static final String NOM_ANIMAL = "nom_animal";
    private static final String ID_PERSONA = "id_persona";

    public static void insertAnimal(int idAnimal, String nomAnimal, int idPersona) {
        try {
            con = Conexion.openConnection();
            String insert = "INSERT INTO " + ANIMAL + " (" + ID_ANIMAL + ", " + NOM_ANIMAL + ", " + ID_PERSONA + ") " + "VALUES (?, ?, ?);";
            PreparedStatement ps = con.prepareStatement(insert);
            ps.setInt(1, idAnimal);
            ps.setString(2, nomAnimal);
            ps.setInt(3, idPersona);
            ps.executeUpdate();
            ps.close();
            Conexion.closeConnection(con);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    

}
