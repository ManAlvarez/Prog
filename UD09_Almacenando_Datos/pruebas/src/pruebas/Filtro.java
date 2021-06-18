/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import java.io.File;
import java.io.FilenameFilter;

/**
 *
 * @author Manuel
 */
public class Filtro implements FilenameFilter {

    String ext;

    public Filtro(String ext) {
        this.ext = ext;
    }

    @Override
    public boolean accept(File dir, String name) {
        return name.contains(ext);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        File f = new File("Directorio");
        String[] files = f.list(new Filtro(".txt"));
        for(int i = 0; i<files.length; i++){
            System.out.println(files[i]);
        }
    }

}
