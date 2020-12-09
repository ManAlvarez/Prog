
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Manuel
 */
public class DiasParaNocheVieja {

    /**
     * @param args the command line arguments
     * @throws java.text.ParseException
     */
    public static void main(String[] args) throws ParseException {
        int dia, mes, nCasos;
        SimpleDateFormat format = new SimpleDateFormat("dd/MM");
        Date fecha, fechaNv;
        String cadena, cadenaNV;
        long dias;
        Scanner sc = new Scanner(System.in);
        nCasos = sc.nextInt();
        sc.nextLine();
        for(int i = 1; i<= nCasos; i++){
            dia = sc.nextInt();
            mes = sc.nextInt();          
            cadena = String.valueOf(dia)+"/"+String.valueOf(mes);
            cadenaNV = "31/12";
            fecha = format.parse(cadena);
            fechaNv = format.parse(cadenaNV);
            dias = (fechaNv.getTime()-fecha.getTime())/(1000*60*60*24);
            if(dias<0){
                dias = 365+dias;
            }
            System.out.println(dias);
        }
    }
}
