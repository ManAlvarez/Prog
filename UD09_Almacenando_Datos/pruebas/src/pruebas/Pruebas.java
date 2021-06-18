/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.StreamTokenizer;
import java.util.Date;

/**
 *
 * @author Manuel
 */
public class Pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        deleteDirectorios();

    }

    public static void escribirPantalla() {
        // ImputStreamReader es un puente de flujos de bytes a flujos de caracteres.
        // Lee bytes y los descodifica a caracteres.
        // BufferdeReader lee texto de un flujo de entrada de caracteres, permitiendo efectuar una lectura eficiente de caracteres, vectores y lineas.
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        String cadena;
        try {
            cadena = teclado.readLine();
            System.out.println("Has escrito:" + cadena);
        } catch (IOException ex) {
            Logger.getLogger(Pruebas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void contarPalabrasNumeros() {
        try {
            int plabras = 0, numeros = 0;
            // StreamTokenizer recibe un flujo de entrada, lo analiza(parse) y divide en diverso pedazos(tokens), permitiendo leer una en cada momento.
            StreamTokenizer st = new StreamTokenizer(new FileReader("prueba.txt"));

            while (st.nextToken() != StreamTokenizer.TT_EOF) {
                if (st.ttype == StreamTokenizer.TT_WORD) {
                    plabras++;
                } else if (st.ttype == StreamTokenizer.TT_NUMBER) {
                    numeros++;
                }
            }
            System.out.println("Número de palabras: " + plabras);
            System.out.println("Número de números: " + numeros);
        } catch (IOException ex) {
            Logger.getLogger(Pruebas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void leerCadena() {
        try {
            StringBuilder stb = new StringBuilder();
            char c;
            // System.in.read() lee el siguiente byte(char) de la entrada estandar.
            while ((c = (char) System.in.read()) != '\n') {
                stb.append(c);
            }
            System.out.println(stb);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void copiarFile() {
        try {
            // Fichero de origen.
            File origen = new File("prueba.txt");
            // Fichero de destino.
            File destino = new File("prueba2.txt");
            if (origen.exists() && destino.exists()) {
                // Flujo de entrada de un archivo.
                InputStream is = new FileInputStream(origen);
                // Flujo de salida de un archivo.
                OutputStream os = new FileOutputStream(destino);
                // Crear una variable para leer el flujo de bytes del origen.
                byte[] buffer = new byte[2048];
                int leng;
                while ((leng = is.read(buffer)) > 0) {
                    os.write(buffer, 0, leng);
                }
                is.close();
                os.close();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void saveText() {
        try {
            PrintWriter out = new PrintWriter(new FileWriter("prueba2.txt"));
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String s;
            while (!(s = br.readLine()).equals("salir")) {
                out.println(s);
            }
            out.close();
            br.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void copiarFile2() {
        try {
            PrintWriter out = new PrintWriter(new FileWriter("prueba.txt"));
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("prueba2.txt")));
            String s;
            while (!(s = br.readLine()).equals("salir")) {
                out.println(s);
                bw.write(s + "\n");
            }
            bw.close();
            out.close();
            br.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void leerArchivo() {
        try {
            FileReader fr = new FileReader("prueba.txt");
            BufferedReader br = new BufferedReader(fr);
            System.out.println(br.readLine());
            fr.close();
            br.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void escribirArchivo() {
        try {
            FileWriter fw = new FileWriter("prueba.txt", true);
            PrintWriter pw = new PrintWriter(fw);
            pw.println("Hola que tal estas");
            pw.close();
            pw.close();
            leerArchivo();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void accesoSecuencial() {
        DataOutputStream archivo = null;
        DataInputStream fich = null;
        String nombre = null;
        int edad = 0;
        try {
            // Creando o abriendo para aÃ±adir el archivo
            archivo = new DataOutputStream(new FileOutputStream("secuencial.dat", true));

            // Escribir el nombre y los apellidos
            archivo.writeUTF("Antonio López Pérez     ");
            archivo.writeInt(33);
            archivo.writeUTF("Pedro Piqueras Peñaranda");
            archivo.writeInt(45);
            archivo.writeUTF("José Antonio Ruiz Pérez ");
            archivo.writeInt(51);
            // Cerrar fichero
            archivo.close();

            // Abrir para leer
            fich = new DataInputStream(new FileInputStream("secuencial.dat"));
            nombre = fich.readUTF();
            System.out.println(nombre);
            edad = fich.readInt();
            System.out.println(edad);
            nombre = fich.readUTF();
            System.out.println(nombre);
            edad = fich.readInt();
            System.out.println(edad);
            nombre = fich.readUTF();
            System.out.println(nombre);
            edad = fich.readInt();
            System.out.println(edad);
            fich.close();

        } catch (FileNotFoundException fnfe) {
            /* Archivo no encontrado */ } catch (IOException ioe) {
            /* Error al escribir */ } catch (Exception e) {
            /* Error de otro tipo*/
            System.out.println(e.getMessage());
        }
    }

    public static void accesoAleatorio() {
        try {
            String registro;
            RandomAccessFile fichero = new RandomAccessFile("clientes.dat", "rw");
            fichero.seek(fichero.length());//nos situamos al final del fichero
            fichero.writeUTF("Adios");//se escribe el entero
            fichero.seek(0);//nos situamos al principio
            while ((registro = fichero.readUTF()) != null) {
                System.out.println(registro);  //se muestra en pantalla
            }

            fichero.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Pruebas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Pruebas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void trabajoConFile() {
        try {
            File archivo = null;
            File directorio = null;
            // renombrar archivo.
            archivo = new File("pruebaRename.txt");
            archivo.createNewFile();
            archivo.renameTo(new File("pruebaRename2.txt"));

            // borrar archivo.
            archivo = new File("pruebaDelete.txt");
            archivo.createNewFile();
            archivo.delete();

            // crear un archivo temporal.
            // File.createTempFile("temp", ".txt");
            // cambiar la fecha de modificación.
            archivo = new File("pruebaEstablecerFecha.txt");
            archivo.createNewFile();
            archivo.setLastModified(new Date().getTime());

            // crear directorios.
            directorio = new File("Directorio");
            directorio.mkdir();

            directorio = new File("Directorio" + File.separator + "SubDirectorio" + File.separator + "SubSubDirectorio");
            directorio.mkdirs();

            for (int i = 0; i <= 4; i++) {
                archivo = new File("Directorio" + File.separator + "prueba" + i + ".txt");
                archivo.createNewFile();
            }

            // listar contenido
            directorio = new File("Directorio");

            File[] archivos = directorio.listFiles();

            for (int i = 0; i < archivos.length; i++) {
                System.out.println(archivos[i].getName());
            }

            String[] archivosString = directorio.list();

            for (int i = 0; i < archivosString.length; i++) {
                System.out.println(archivosString[i]);
            }

            File[] archivosRaiz = File.listRoots();

            for (int i = 0; i < archivosRaiz.length; i++) {
                System.out.println(archivosRaiz[i].getPath());
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    // Creamos una clase que implemete la interfaz y implementamos el método abstracto.
    public static class Filtro implements FilenameFilter {

        String extension;

        public Filtro(String extension) {
            this.extension = extension;
        }

        @Override
        public boolean accept(File dir, String name) {
            return name.endsWith(extension);
        }
    }

    public static void listarPorExtension() {
        try {
            File fichero = new File("Directorio");
            // Le pasamos el filtro en el metodo list().
            String[] listaArchivos = fichero.list(new Filtro(".odt"));

            for (int i = 0; i < listaArchivos.length; i++) {
                System.out.println(listaArchivos[i]);
            }
        } catch (Exception e) {
        }
    }

    public static void deleteDirectorios() {
        try {
            File directorio = new File("Directorio");
            File[] files = directorio.listFiles();
            for (File file : files) {
                if (file.isDirectory()) {
                    borrarTodoDir(file);
                    file.delete();
                }
            }
        } catch (Exception e) {

        }
    }

    private static boolean borrarTodoDir(File file) {
        try {
            if (file.isDirectory()) {
                File[] files = file.listFiles();
                for (File f : files) {
                    if (file.isDirectory()) {
                        borrarTodoDir(f);
                        f.delete();
                    }
                }
            } else {
                file.delete();
            }
            return true;

        } catch (Exception e) {
            return false;
        }
    }

}
