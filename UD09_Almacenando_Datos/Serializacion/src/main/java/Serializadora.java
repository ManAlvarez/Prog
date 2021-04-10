
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Manuel
 */
public class Serializadora {
    
    private ObjectInputStream lectorDeObjetos;
    private ObjectOutputStream escritorDeObjetos;
    
    public void escrtibirObjeto(Object objeto){
        try {
            escritorDeObjetos = new ObjectOutputStream(new FileOutputStream("objeto.dat"));
            escritorDeObjetos.writeObject(objeto);
        } catch (IOException ex) {
            Logger.getLogger(Serializadora.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public Object leerObjeto(String nombreDelArchivo){
        Object retorno = null;
        try {
            lectorDeObjetos = new ObjectInputStream(new FileInputStream(nombreDelArchivo));
            retorno = lectorDeObjetos.readObject();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Serializadora.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Serializadora.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Serializadora.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }
    
}
