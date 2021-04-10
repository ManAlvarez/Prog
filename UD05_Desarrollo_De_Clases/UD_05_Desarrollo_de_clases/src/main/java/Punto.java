/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Manuel
 */
class Punto {

    // Atributos
    private int x, y;
    // Atributos de la clase
    public static int cantidadPuntos;
    public static final String nombre = "Punto";

    public Punto() {
    }

    public Punto(int x, int y) {
        this.x = x;
        this.y = y;
        cantidadPuntos++; // Suponiendo que tengamos un atributo estático cantidadPuntos
    }

    // Métodos
    int obtenerX() {
        return x;
    }

    int obtenerY() {
        return y;
    }

    void establecerX(int vx) {
        x = vx;
    }

    void establecerY(int vy) {
        y = vy;
    }

}
