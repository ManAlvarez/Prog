/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools;

import Modelo.Persona;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.tools.FileObject;


/**
 *
 * @author Manuel
 */
public class Tools {
    
    public static boolean isNumero(String cadena){      
        Pattern p = Pattern.compile("^[0-9]$");
        Matcher m = p.matcher(cadena);
        return m.matches();
    }
    
    public static void guardarFichero(ArrayList<Persona> personas){
        try {
            FileOutputStream fos = new FileOutputStream("data.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(personas);
            fos.close();
            oos.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Tools.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Tools.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    private static ArrayList<Persona> personas = new ArrayList<>();
    public static void leerFichero(){
        
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("data.dat"));
            personas = (ArrayList<Persona>) ois.readObject();
            ois.close();
            for(Persona p:personas){
                System.out.println(p.getIdPersona()+","+p.getNombre()+","+p.getApellidos());
            }
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Tools.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Tools.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Tools.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
