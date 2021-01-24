/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Manuel
 */
class Point {

    private int x;
    private int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double distance(Point other) {
        double x1, x2, y1, y2;
        x2 = Double.parseDouble(String.valueOf(other.x));
        x1 = Double.parseDouble(String.valueOf(this.x));
        y2 = Double.parseDouble(String.valueOf(other.y));
        y1 = Double.parseDouble(String.valueOf(this.y));
        return Math.sqrt(Math.pow(x2 - x1, 2)+ Math.pow(y2-y1, 2));
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    
}
