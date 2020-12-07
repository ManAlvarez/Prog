/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Manuel
 */
public class Punto2D {

    private double cx, cy;

    public Punto2D() {
        this.cx = 0.0;
        this.cy = 0.0;
    }

    public Punto2D(double cx, double cy) {
        this.cx = cx;
        this.cy = cy;
    }

    public Punto2D(Punto2D p) {
        this.cx = p.cx;
        this.cy = p.cy;
    }

    public double getX() {
        return cx;
    }

    public void setX(double cx) {
        this.cx = cx;
    }

    public double getY() {
        return cy;
    }

    public void setY(double cy) {
        this.cy = cy;
    }

    public void flip() {
        double auxX = this.cx;
        this.cx = this.cy;
        this.cy = auxX;
    }

    public double dist(Punto2D p) {
        //((x2-x1)² + (y2-y1)²)
        return Math.sqrt((Math.pow((p.cx - this.cx), 2)) + (Math.pow((p.cy - this.cy), 2)));
    }

    public double manhattanDist(Punto2D p) {
        //((x2-x1) + (y2-y1))
        return ((Math.abs(p.cx - this.cx)) + (Math.abs(p.cy - this.cy)));
    }

    public double slope(Punto2D p) {
        //((y2-y1)/(x2-x1))
        return ((p.cy - this.cy) / (p.cx - this.cx));
    }

    public String toString() {
        //Punto2D[<valor_de_la_coordenada_X>,<valor_de_la_coordenada_Y>]
        return "Punto2D[" + cx + "," + cy + "]";
    }

}
