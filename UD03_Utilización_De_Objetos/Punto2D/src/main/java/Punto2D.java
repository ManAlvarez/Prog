/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author manue
 */
public class Punto2D {

    private double cx;
    private double cy;

    public Punto2D() {
        this.cx = 0.0;
        this.cy = 0.0;
    }

    public Punto2D(double cx, double cy) {
        this.cx = cx;
        this.cy = cy;
    }

    public Punto2D(Punto2D obj) {
        this.cx = obj.cx;
        this.cy = obj.cy;
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
        double auxCx = this.cx;
        double auxCy = this.cy;
        this.cx = auxCy;
        this.cy = auxCx;
    }

    public double dist(Punto2D p) {
        return Math.sqrt(((p.cx - this.cx) * (p.cx - this.cx)) + ((p.cy - this.cy) * (p.cy - this.cy)));
    }

    public double manhattanDist(Punto2D p) {
       double dx = Math.abs(p.cx - this.cx);
       double dy = Math.abs(p.cy - this.cy);
       return dx+dy; 
    }

    public double slope(Punto2D p) {
        return (p.cy - this.cy)/(p.cx - this.cx);
    }

    public String toString() {
        return "Punto2D[" + cx + "," + cy + "]";
    }

}
