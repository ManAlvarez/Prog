package PROG05_Ejerc1_util;

import java.time.LocalDate;

public class Util {
    /** Valida el kilometraje. */
    public static boolean validaKM(int km) {
        return (km > 0);
    }

    /** Valida que la fecha actual sea posterior a la de matriculación. */
    public static boolean validaFechaMat(LocalDate fechMatricula) {
        return (LocalDate.now().isAfter(fechMatricula));
    }

    /**
     * Valida el DNI.
     *
     * Comprueba la letra de control del DNI de nacionales y NIE. Excluye los
     * casos especiales que comienzan por K, L o M (menores de 14 año, 
     * residentes temprales)
     *
     * @param dni DNI del propietario del vehículo
     * @throws Exception
     */
    public static void validaDNI(String dni) throws Exception {
        String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
        String dniEspecial = "KLM";

        if (dni.length() != 9)
            throw new Exception("Longitud de DNI incorrecta");

        dni = dni.toUpperCase();
        String s_numDNI = dni.substring(0, 8); // primeros 8 dígitos

        // Chequea si es un DNI especial (menores de 14, residentes temporales,...). No se hace la
        // validación del dígito de control
        if (dniEspecial.indexOf(dni.charAt(0)) >= 0)
            throw new Exception("DNI especial menores de 14 y temporales");

        // NIE
        s_numDNI = s_numDNI.replaceFirst("X", "0").replaceFirst("Y", "1").replaceFirst("Z", "2");

        try {
            if (letras.charAt(Integer.parseInt(s_numDNI) % 23) != dni.charAt(8))
                throw new Exception("Letra de DNI incorrecta");
        } catch (NumberFormatException e) {
            throw new Exception("Número DNI no válido");
        }
    }
}
