/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Manuel
 */
public class MinusculasAMayusculasYViceversa {

    
    public static void main(String[] args) {  
        System.out.println(flipChar("En un lugar de la Mancha"));       
    }
    
    public static String flipChar(String cadena){
        String cadenaAux = "";
        for(int i = 0; cadena.length()>i;i++){
            if(Character.isLetter(cadena.charAt(i))){
                cadenaAux += (char)decimal(revertirCaracter(binario(cadena.charAt(i))));
            }else{
                cadenaAux += cadena.charAt(i);
            }
        }
        return cadenaAux;
    }
    
    public static int binario(int n){
        int exp=0, dig=0, b=0;
        while(n!=0){
            dig = n%2;
            b += dig*Math.pow(10,exp);
            exp++;
            n = n/2;
        }
        return b;
    }
    
    public static int decimal(int n){
        int exp=0, dig=0, d=0;
        while(n!=0){
            dig = n%10;
            d += dig*Math.pow(2,exp);
            exp++;
            n = n/10;
        }
        return d;
    }
    
    public static int revertirCaracter(int n){
        String num = String.valueOf(n);
        if(num.charAt(1)=='0') n+= 100000;
        else n-= 100000;  
        return n;
    }

}