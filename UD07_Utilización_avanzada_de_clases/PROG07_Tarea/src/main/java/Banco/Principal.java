/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Banco;

/**
 *
 * @author Manuel
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    
    private static Banco banco = new Banco();
    
    public static void main(String[] args) {
        // TODO code application logic here
        accionMenuPrincipal();
    }
    
    private static void accionMenuPrincipal(){
        int op = -1;
        while(true){
            verMenuPrincipal();
            op = obtenerOpcionMenu();
            if(op != -1 && op >= 1 && op <= 7) break;
        }
        seleccionarOpcionMenu(op);
    }
    
    private static void verMenuPrincipal() {
        System.out.println();
        System.out.println("**********************************************");
        System.out.println("******** GESTION DE CUENTAS BANCARIAS ********");
        System.out.println("**********************************************");
        System.out.println(" 1 - Abrir una nueva cuenta");
        System.out.println(" 2 - Ver un listado de las cuentas disponibles");
        System.out.println(" 3 - Obtener los datos de una cuenta concreta");
        System.out.println(" 4 - Realizar un ingreso en una cuenta");
        System.out.println(" 5 - Retirar efectivo de una cuenta");
        System.out.println(" 6 - Consultar el saldo actual de una cuenta");
        System.out.println(" 7 - Salir de la aplicación");
        System.out.println();
    }
    
    private static int obtenerOpcionMenu(){
        int opcion = -1;
        opcion = Util.insertarNumero();
        return opcion;
    }
    
    private static void seleccionarOpcionMenu(int opcion){      
        switch(opcion){
            case 1:
                insertarDatosCuenta();
                accionMenuPrincipal();
                break;
            case 2:
                listarCuentas();
                accionMenuPrincipal();
                break;
            case 3:
                accionMenuPrincipal();
                break;
            case 4:
                accionMenuPrincipal();
                break;
            case 5:
                accionMenuPrincipal();                
                break;
            case 6:
                accionMenuPrincipal();
                break;
            case 7:
                System.exit(0);                
                break;
            default:
                break;
        }
    }
    
    private static Persona insertarDatosPersonales(){
        
        String nombre = "";
        String apellidos = "";
        String dni = "";
        
        System.out.println("Nombre: ");
        nombre = Util.insertarCadena().trim().toUpperCase();
        System.out.println("Apellidos: ");
        apellidos = Util.insertarCadena().trim().toUpperCase();      
//        while(dni == null || !Util.validarDni(dni)){
//            System.out.println("DNI: ");
//            dni = Util.insertarCadena().trim().toUpperCase();
//        }
        System.out.println("DNI: ");
        dni = Util.insertarCadena().trim().toUpperCase();
        return new Persona(nombre, apellidos, dni);
    }
    
    private static void verMenuTipoDeCuenta() {
        System.out.println();
        System.out.println("**********************************************");
        System.out.println("********** TIPO DE CUENTA BANCARIA ***********");
        System.out.println("**********************************************");
        System.out.println(" 1 - Cuenta de ahorro");
        System.out.println(" 2 - Cuenta corriente personal");
        System.out.println(" 3 - Cuenta corriente de empresa");
        System.out.println();
    }
        
    private static int obtenerTipoCuenta(){
        int tipoCuenta = -1;
        tipoCuenta = Util.insertarNumero();
        return tipoCuenta;
    }
           
    private static void insertarDatosCuenta(){
        
        Persona datosPersonales = insertarDatosPersonales();
        double saldoInicial;
        int tipoCuenta = -1;
        String numeroDeCuenta = "";
        
        while(true){
            verMenuTipoDeCuenta();
            tipoCuenta = obtenerTipoCuenta();
            if(tipoCuenta != -1 && tipoCuenta >= 1 && tipoCuenta <= 3) break;
        }
        System.out.println("Saldo Inicial: ");
        saldoInicial = Util.insertarNumeroDecimal();
        
//        while(numeroDeCuenta == null || !Util.validarIBAN(numeroDeCuenta)){
//            System.out.println("IBAN: ");
//            numeroDeCuenta = Util.insertarCadena().trim().toUpperCase();
//        }
        System.out.println("IBAN: ");
        numeroDeCuenta = Util.insertarCadena().trim().toUpperCase();
             
        switch(tipoCuenta){
            case 1: 
                insertarDatosCuentaDeAhorro(datosPersonales, saldoInicial, numeroDeCuenta);
                break;
            case 2:
                insertarDatosCuentaCorrientePersonal(datosPersonales, saldoInicial, numeroDeCuenta);
                break;
            case 3:
                insertarDatosCuentaCorrienteDeEmpresa(datosPersonales, saldoInicial, numeroDeCuenta);
                break;           
            default:
                break;
        }  
    }
        
    private static void insertarDatosCuentaDeAhorro(Persona datosPersonales, double saldoInicial, String numeroDeCuenta){
        CuentaBancaria nuevaCuentaBancaria;
        CuentaAhorro nuevaCuentaAhorro = new CuentaAhorro();
        double tipoInteres = -1;
        System.out.println("Tipo de interés: ");
        tipoInteres = Util.insertarNumeroDecimal();
        nuevaCuentaAhorro.setTitular(datosPersonales);
        nuevaCuentaAhorro.setSaldo(saldoInicial);
        nuevaCuentaAhorro.setNumeroCuenta(numeroDeCuenta);
        nuevaCuentaAhorro.setTipoInteres(tipoInteres);
        nuevaCuentaBancaria = nuevaCuentaAhorro;
        banco.abrirCuenta(nuevaCuentaBancaria);
    }
    
    private static void insertarDatosCuentaCorrientePersonal(Persona datosPersonales, double saldoInicial, String numeroDeCuenta){
        CuentaBancaria nuevaCuentaBancaria;
        CuentaCorrientePersonal nuevaCuentaCorrientePersonal = new CuentaCorrientePersonal();
        double comisionDeMantenimiento = -1;
        System.out.println("Comisión de mantenimiento: ");
        comisionDeMantenimiento = Util.insertarNumeroDecimal();
        nuevaCuentaCorrientePersonal.setTitular(datosPersonales);
        nuevaCuentaCorrientePersonal.setSaldo(saldoInicial);
        nuevaCuentaCorrientePersonal.setNumeroCuenta(numeroDeCuenta);
        nuevaCuentaCorrientePersonal.setComisionMantenimiento(comisionDeMantenimiento);
        nuevaCuentaBancaria = nuevaCuentaCorrientePersonal;
        banco.abrirCuenta(nuevaCuentaBancaria);
    }
    
    private static void insertarDatosCuentaCorrienteDeEmpresa(Persona datosPersonales, double saldoInicial, String numeroDeCuenta){
        CuentaBancaria nuevaCuentaBancaria;
        CuentaCorrienteEmpresa nuevaCuentaCorrienteDeEmpresa = new CuentaCorrienteEmpresa();
        double maxDescubiertoPermitido = -1;
        double tipoInteresPorDescubierto = -1;
        double comisionFijaPorDescubierto = -1;
        System.out.println("Máximo descubierto permitido: ");
        maxDescubiertoPermitido = Util.insertarNumeroDecimal();
        System.out.println("Tipo de interés por descubierto: ");
        tipoInteresPorDescubierto = Util.insertarNumeroDecimal();
        System.out.println("Comisión fija por cada descubierto: ");
        comisionFijaPorDescubierto = Util.insertarNumeroDecimal();
        nuevaCuentaCorrienteDeEmpresa.setTitular(datosPersonales);
        nuevaCuentaCorrienteDeEmpresa.setSaldo(saldoInicial);
        nuevaCuentaCorrienteDeEmpresa.setNumeroCuenta(numeroDeCuenta);
        nuevaCuentaCorrienteDeEmpresa.setMaxDescubiertoPermitido(maxDescubiertoPermitido);
        nuevaCuentaCorrienteDeEmpresa.setTipoInteresDescubierto(tipoInteresPorDescubierto);
        nuevaCuentaCorrienteDeEmpresa.setComisionFijaPorDescubierto(comisionFijaPorDescubierto);
        nuevaCuentaBancaria = nuevaCuentaCorrienteDeEmpresa;
        banco.abrirCuenta(nuevaCuentaBancaria);
    }
    
    private static void listarCuentas(){
        String[] cuentas = banco.listadoCuentas();
        for(int i = 0; i < cuentas.length; i++){
                System.out.println(cuentas[i]);
                
        }
    }
        
        
}
