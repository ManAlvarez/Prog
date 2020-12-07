/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Manuel
 */
public class Prog {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Punto2D p = new Punto2D();
        System.out.println(p);

        Punto2D p1 = new Punto2D(3.2, -4.8);
        System.out.println(p1);
        
        Punto2D p11 = new Punto2D(4.5, 5.5);
        Punto2D p21 = new Punto2D(p11);
        System.out.println(p21);

        Punto2D p2 = new Punto2D();
        p2.setX(5.5);
        p2.setY(-2.0);
        System.out.println(p2);
        
        Punto2D p3 = new Punto2D(5.5, -2.0);
        System.out.println(p3.getX() + " " + p3.getY());
        
        Punto2D p4 = new Punto2D(3.2, -4.8);
        p4.flip();
        System.out.println(p4);
        
        Punto2D p5 = new Punto2D(-3.0, 4.0);
        System.out.println(p5.dist(new Punto2D()));
        System.out.println(p5.dist(new Punto2D(2.5, 1.5)));
        
        Punto2D p12 = new Punto2D(-2.0, 3.0);
        Punto2D p22 = new Punto2D(2.0, 1.0);
        System.out.println(p12.manhattanDist(p22));
        System.out.println(p22.manhattanDist(p12));
        
        Punto2D p13 = new Punto2D(-2.0, 3.0);
        Punto2D p23 = new Punto2D(2.0, 1.0);
        System.out.println(p13.slope(p23));
        p13.setY(-1);
        System.out.println(p13.slope(p23));
    }

}
