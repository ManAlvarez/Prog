
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
public class MinutosParaLas24 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        String fecha;
        String[] horasMinutos;
        int horas, minutos, totalMinutos;
        Scanner sc = new Scanner(System.in);
        while (true) {
            fecha = sc.next();
            if (fecha.equalsIgnoreCase("00:00")) {
                break;
            } else {
                horasMinutos = fecha.split(":");
                horas = Integer.parseInt(horasMinutos[0]);
                minutos = Integer.parseInt(horasMinutos[1]);
                totalMinutos = ((24 - (horas +1)) * 60) + (60 - minutos);
                System.out.println(totalMinutos);
            }
        }
    }

}
