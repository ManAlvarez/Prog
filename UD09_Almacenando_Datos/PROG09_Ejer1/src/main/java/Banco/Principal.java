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
    
    // Instanciamos la clase Banco y creamos el objeto banco.
    private static Banco banco = new Banco();
    
    public static void main(String[] args) {
        // TODO code application logic here
        banco.leerObjeto();
        accionMenuPrincipal();
    }
    
    
    // Método para seleccionar una opción del menú.
    private static void accionMenuPrincipal(){
        int op = -1;
        while(true){
            verMenuPrincipal();
            op = obtenerOpcionMenu();
            if(op != -1 && op >= 1 && op <= 9) break;
        }
        seleccionarOpcionMenu(op);
    }
    
    // Método para mostrar el menú principal.
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
        System.out.println(" 7 - Eliminar Cuenta Bancaria");
        System.out.println(" 8 - Listado clientes");
        System.out.println(" 9 - Salir de la aplicación");
        System.out.println();
    }
    
    /**
     * Método para obtener el número de la opción del menú.
     * @return int.
     */
    private static int obtenerOpcionMenu(){
        int opcion = -1;
        opcion = Util.insertarNumero();
        return opcion;
    }
    
    // Método para redireccionar la opción seleccionada en el menú.
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
                obtenerDatosCuenta();
                accionMenuPrincipal();
                break;
            case 4:
                realizarIngreso();
                accionMenuPrincipal();
                break;
            case 5:
                realizarRetirada();
                accionMenuPrincipal();                
                break;
            case 6:
                obtenerSaldoCuenta();
                accionMenuPrincipal();
                break;
            case 7:
                eliminarCuenta();
                accionMenuPrincipal();
                break;
            case 8:
                banco.listarClientes();
                Util.pulsarEnter();
                accionMenuPrincipal();               
                break;
            case 9:
                banco.escribirObjeto();
                System.exit(0);                
                break;
            default:
                break;
        }
    }
    
    /***
     * Método para insertar todos los datos del titular de la cuenta bancaria.
     * @return Persona.
     */
    private static Persona insertarDatosPersonales(){
        
        String nombre = "";
        String apellidos = "";
        String dni = null;
        
        System.out.println("Nombre: ");
        nombre = Util.insertarCadena().trim().toUpperCase();
        System.out.println("Apellidos: ");
        apellidos = Util.insertarCadena().trim().toUpperCase();      
        while(dni == null || !Util.validarDni(dni)){
            System.out.println("DNI: ");
            dni = Util.insertarCadena().trim().toUpperCase();
        }
        return new Persona(nombre, apellidos, dni);
    }
    
    // Método para visualizar el menú para seleccionar el tipo de cuenta.
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
    
    // Método para obtener el número del tipo de cuenta seleccionado.
    private static int obtenerTipoCuenta(){
        int tipoCuenta = -1;
        tipoCuenta = Util.insertarNumero();
        return tipoCuenta;
    }
     
    // Método para insertar los datos necesarios para abrir una cuenta bancaria.
    private static void insertarDatosCuenta(){
        
        Persona datosPersonales = insertarDatosPersonales();
        double saldoInicial;
        int tipoCuenta = -1;
        String numeroDeCuenta = null;
        
        while(true){
            verMenuTipoDeCuenta();
            tipoCuenta = obtenerTipoCuenta();
            if(tipoCuenta != -1 && tipoCuenta >= 1 && tipoCuenta <= 3) break;
        }
        System.out.println("Saldo Inicial: ");
        saldoInicial = Util.insertarNumeroDecimal();
        
        while(numeroDeCuenta == null || !Util.validarIBAN(numeroDeCuenta)){
            System.out.println("IBAN: ");
            numeroDeCuenta = Util.insertarCadena().trim().toUpperCase();
            if(banco.informacionCuenta(numeroDeCuenta) != null){
                numeroDeCuenta = null;
                System.out.println("La cuenta ya existe.");
            }
        }
                 
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
       
    /**
     * Método para insertar los datos necesarios para abrir una cuenta de ahorro.
     * @param datosPersonales
     * @param saldoInicial
     * @param numeroDeCuenta 
     */
    private static void insertarDatosCuentaDeAhorro(Persona datosPersonales, double saldoInicial, String numeroDeCuenta){
        CuentaBancaria nuevaCuentaBancaria;
        CuentaAhorro nuevaCuentaAhorro = new CuentaAhorro();
        double tipoInteres = -1;
        System.out.println("Tipo de interés: ");
        tipoInteres = Util.insertarNumeroDecimal();
        nuevaCuentaAhorro.titular = datosPersonales;
        nuevaCuentaAhorro.saldo = saldoInicial;
        nuevaCuentaAhorro.numeroCuenta = numeroDeCuenta;
        nuevaCuentaAhorro.setTipoInteres(tipoInteres);
        nuevaCuentaBancaria = nuevaCuentaAhorro;
        banco.abrirCuenta(nuevaCuentaBancaria);
        System.out.println("La cuenta de ahorro a sido creada con éxito.");
        Util.pulsarEnter();
    }
    
    /**
     * Método para insertar los entidades autorizadas en las cuentas corrientes.
     * @return String.
     */
    public static String insertarEntidadesAutorizadas(){
        boolean rep = true;
        String decision = "";
        String entidadAutorizada = "";
        String entidadesAutorizadas = "";
        while(rep){
            System.out.println("Deseas añadir una Entidad Autorizada (S/N): ");
            decision = Util.insertarCadena();
            if(decision.trim().equalsIgnoreCase("S") || decision.trim().equalsIgnoreCase("N")){
                if(decision.trim().equalsIgnoreCase("S")){
                    if(!entidadesAutorizadas.equalsIgnoreCase(""))entidadesAutorizadas = entidadesAutorizadas + ";";
                    System.out.println("Entidad Autorizada: ");
                    entidadAutorizada = Util.insertarCadena();
                    entidadesAutorizadas = entidadesAutorizadas + entidadAutorizada;
                }else{
                    rep = false;                            
                }
            }else{
                System.out.println("Respuesta erronea, debes insertar 'S' si quieres añadir o 'N' si no quieres añadir una entidad.");
            }
        }
        return entidadesAutorizadas;
    }
    
    /**
     * Método para insertar los datos necesarios para abrir una cuenta corriente personal.
     * @param datosPersonales
     * @param saldoInicial
     * @param numeroDeCuenta 
     */
    private static void insertarDatosCuentaCorrientePersonal(Persona datosPersonales, double saldoInicial, String numeroDeCuenta){
        CuentaBancaria nuevaCuentaBancaria;
        CuentaCorrientePersonal nuevaCuentaCorrientePersonal = new CuentaCorrientePersonal();
        double comisionDeMantenimiento = -1;
        nuevaCuentaCorrientePersonal.entidadesAutorizadas = insertarEntidadesAutorizadas();
        System.out.println("Comisión de mantenimiento: ");
        comisionDeMantenimiento = Util.insertarNumeroDecimal();
        nuevaCuentaCorrientePersonal.titular = datosPersonales;
        nuevaCuentaCorrientePersonal.saldo = saldoInicial;
        nuevaCuentaCorrientePersonal.numeroCuenta = numeroDeCuenta;
        nuevaCuentaCorrientePersonal.setComisionMantenimiento(comisionDeMantenimiento);
        nuevaCuentaBancaria = nuevaCuentaCorrientePersonal;
        banco.abrirCuenta(nuevaCuentaBancaria);
        System.out.println("La cuenta corriente personal a sido creada con éxito.");
        Util.pulsarEnter();
    }
    
    // Método para insertar los datos necesarios para abrir una cuenta corriente de empresa.
    private static void insertarDatosCuentaCorrienteDeEmpresa(Persona datosPersonales, double saldoInicial, String numeroDeCuenta){
        CuentaBancaria nuevaCuentaBancaria;
        CuentaCorrienteEmpresa nuevaCuentaCorrienteDeEmpresa = new CuentaCorrienteEmpresa();
        double maxDescubiertoPermitido = -1;
        double tipoInteresPorDescubierto = -1;
        double comisionFijaPorDescubierto = -1;
        nuevaCuentaCorrienteDeEmpresa.entidadesAutorizadas = insertarEntidadesAutorizadas();
        System.out.println("Máximo descubierto permitido: ");
        maxDescubiertoPermitido = Util.insertarNumeroDecimal();
        System.out.println("Tipo de interés por descubierto: ");
        tipoInteresPorDescubierto = Util.insertarNumeroDecimal();
        System.out.println("Comisión fija por cada descubierto: ");
        comisionFijaPorDescubierto = Util.insertarNumeroDecimal();
        nuevaCuentaCorrienteDeEmpresa.titular = datosPersonales;
        nuevaCuentaCorrienteDeEmpresa.saldo = saldoInicial;
        nuevaCuentaCorrienteDeEmpresa.numeroCuenta = numeroDeCuenta;
        nuevaCuentaCorrienteDeEmpresa.setMaxDescubiertoPermitido(maxDescubiertoPermitido);
        nuevaCuentaCorrienteDeEmpresa.setTipoInteresDescubierto(tipoInteresPorDescubierto);
        nuevaCuentaCorrienteDeEmpresa.setComisionFijaPorDescubierto(comisionFijaPorDescubierto);
        nuevaCuentaBancaria = nuevaCuentaCorrienteDeEmpresa;
        banco.abrirCuenta(nuevaCuentaBancaria);
        System.out.println("La cuenta corriente de empresa a sido creada con éxito.");
        Util.pulsarEnter();
    }
    
    // Método para listar las cuentas del banco.
    private static void listarCuentas(){
        String[] cuentas = banco.listadoCuentas();
        int inicio  = -1;
        int fin = -1;
        for(int i = 0; i < cuentas.length; i++){
                inicio = cuentas[i].indexOf("Persona{");
                fin = cuentas[i].indexOf("[");
                System.out.println(cuentas[i].substring(inicio, fin));              
        }
        Util.pulsarEnter();
    }
    
    // Método para obtener una cuenta indicandole el IBAN.
    private static void obtenerDatosCuenta(){
        String datos = "";
        String numeroDeCuenta = null;
        while(numeroDeCuenta == null || !Util.validarIBAN(numeroDeCuenta)){
            System.out.println("IBAN: ");
            numeroDeCuenta = Util.insertarCadena().trim().toUpperCase();         
        }
        datos = banco.informacionCuenta(numeroDeCuenta);
        if(datos != null){
            System.out.println(datos);
            Util.pulsarEnter();
        }else{
            System.out.println("La cuenta no existe.");
            Util.pulsarEnter();
        }
    }
    
    // Método para realizar un ingreso en una cuenta indicando el IBAN y la cantidad a ingresar.
    private static void realizarIngreso(){
        boolean exito = false;
        String numeroDeCuenta = null;
        double ingreso = 0;
        while(numeroDeCuenta == null || !Util.validarIBAN(numeroDeCuenta)){
            System.out.println("IBAN: ");
            numeroDeCuenta = Util.insertarCadena().trim().toUpperCase();
        }
        if(banco.informacionCuenta(numeroDeCuenta) != null){
            System.out.println("Ingreso: ");
            ingreso = Util.insertarNumeroDecimal();
            exito = banco.ingresoCuenta(numeroDeCuenta, ingreso);
            if(exito){
                System.out.println("Ingreso realizado con exito.");
                Util.pulsarEnter();
            }else{
                System.out.println("Error al realizar el ingreso.");
                Util.pulsarEnter();
            }
        }else{
            System.out.println("La cuenta no existe.");
            Util.pulsarEnter();
        }           
    }
    
    // Método para realizar una retirada en una cuenta indicando el IBAN y la cantidad a retirar.
    private static void realizarRetirada(){
        boolean exito = false;
        String numeroDeCuenta = null;
        double retirar = 0;
        while(numeroDeCuenta == null || !Util.validarIBAN(numeroDeCuenta)){
            System.out.println("IBAN: ");
            numeroDeCuenta = Util.insertarCadena().trim().toUpperCase();
        }
        if(banco.informacionCuenta(numeroDeCuenta) != null){
            System.out.println("Retirar: ");
            retirar = Util.insertarNumeroDecimal();
            exito = banco.retiradaCuenta(numeroDeCuenta, retirar);
            if(exito){
                System.out.println("Retirada realizada con exito.");
                Util.pulsarEnter();
            }else{
                System.out.println("Error al realizar la retirada.");
                Util.pulsarEnter();
            }
        }
        else{
            System.out.println("La cuenta no existe.");
            Util.pulsarEnter();
        }      
    }
    
    // Método para obtener el saldo de una cuenta indicando el IBAN.
    private static void obtenerSaldoCuenta(){
        double saldo = 0;
        String numeroDeCuenta = null;
        while(numeroDeCuenta == null || !Util.validarIBAN(numeroDeCuenta)){
            System.out.println("IBAN: ");
            numeroDeCuenta = Util.insertarCadena().trim().toUpperCase();
        }
        if(banco.informacionCuenta(numeroDeCuenta) != null){
            saldo = banco.obtenerSaldo(numeroDeCuenta);
            if(saldo != -1){
                System.out.println(saldo);
                Util.pulsarEnter();
            }else{
                System.out.println("Error al obtener el saldo.");
                Util.pulsarEnter();
            }
        }
        else{
            System.out.println("La cuenta no existe.");
            Util.pulsarEnter();
        }      
    }
    
    // Método para eliminar una cuenta existente con saldo 0 indicando el IBAN.
    private static void eliminarCuenta(){
        String datos = "";
        double saldo = 0;
        String numeroDeCuenta = null;
        while(numeroDeCuenta == null || !Util.validarIBAN(numeroDeCuenta)){
            System.out.println("IBAN: ");
            numeroDeCuenta = Util.insertarCadena().trim().toUpperCase();         
        }
        datos = banco.informacionCuenta(numeroDeCuenta);
        if(datos != null){
            saldo = banco.obtenerSaldo(numeroDeCuenta);
                if(saldo != -1){
                    if(saldo == 0){
                        banco.eliminarCuenta(numeroDeCuenta);
                        System.out.println("La cuenta ha sido elimanda con éxito.");
                        Util.pulsarEnter();
                    }else if (saldo < 0){
                        System.out.println("No se puede eliminar cuentas con saldo negativo.");
                        Util.pulsarEnter();                  
                    }else if (saldo > 0){
                        System.out.println("No se puede eliminar cuentas con saldo positivo.");
                        Util.pulsarEnter();
                    }
                }else{
                    System.out.println("Error al obtener el saldo.");
                    Util.pulsarEnter();
                }
        }else{
            System.out.println("La cuenta no existe.");
            Util.pulsarEnter();
        }
    }

        
}
