/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Manuel
 */
public class Sistema {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Contacto contacto = new Contacto("Manuel","Álvarez");
        Serializadora serializadora = new Serializadora();
        serializadora.escrtibirObjeto(contacto);
        contacto = (Contacto)serializadora.leerObjeto("objeto.dat");
        System.out.println(contacto.getNombre());
        System.out.println(contacto.getApellido());
    }
    
}
