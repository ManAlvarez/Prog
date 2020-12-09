
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
public class SumaMasUno {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        String num, suma, formatoSumaRev, formatoSuma, sumaTotal;
        int cont;
        long sumaLong, sumaTotalLong;

        while (true) {
            
            cont = 0;
            formatoSumaRev = "";
            formatoSuma = "";
            
            num = sc.nextLine();
            
            if (num.equals("0")) {
                break;
            }
            
            suma = num.replace(".", "");
            sumaLong = Long.parseLong(suma);
            sumaTotalLong = sumaLong + 1;
            sumaTotal = String.valueOf(sumaTotalLong).replace("-", "");
            
            for(int i=sumaTotal.length()-1; i>=0;i--){
                formatoSumaRev+= sumaTotal.charAt(i);
                cont++;
                if(cont==3){
                    formatoSumaRev+=".";
                    cont = 0;
                }
            }
            
            for(int j = formatoSumaRev.length()-1; j>=0; j--){
                formatoSuma += formatoSumaRev.charAt(j);
            }
            
            System.out.println(formatoSuma);
        }
    }
}
