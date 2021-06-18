package pruebas;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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
public class Flujos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        escribirBytes();
    }

    public static void escribirBytes() {
        try {
            //Cramos el archivo.
            File file = new File("prueba.dat");
            file.createNewFile();
            // Creamos el contenido.
            String texto = "Hola buenos días";
            byte[] textoByte = texto.getBytes();
            // Creamos el flujo de salida.
            OutputStream flujoSalida = new FileOutputStream(file);
            BufferedOutputStream bufferSalida = new BufferedOutputStream(flujoSalida);
            bufferSalida.write(textoByte);
            bufferSalida.close();
            flujoSalida.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Flujos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Flujos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Flujos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
        }
    }

    public static void leerBytes() {
        try {
            InputStream flujoEntrada = new FileInputStream("prueba.dat");
            BufferedInputStream bufferEntrada = new BufferedInputStream(flujoEntrada);
            if(bufferEntrada.read()>0){
               
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Flujos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Flujos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Flujos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
        }
    }

}
