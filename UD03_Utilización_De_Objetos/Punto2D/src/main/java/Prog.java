/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author manue
 */
public class Prog {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Punto2D p = new Punto2D();
        System.out.println(p);

        Punto2D p1 = new Punto2D(3.2, -4.8);
        System.out.println(p1);

        Punto2D p2 = new Punto2D(4.5, 5.5);
        Punto2D p3 = new Punto2D(p2);
        System.out.println(p3);

        Punto2D p4 = new Punto2D();
        p4.setX(5.5);
        p4.setY(-2.0);
        System.out.println(p4);

        Punto2D p5 = new Punto2D(5.5, -2.0);
        System.out.println(p5.getX() + " " + p5.getY());

        Punto2D p6 = new Punto2D(3.2, -4.8);
        p6.flip();
        System.out.println(p6);

        Punto2D p7 = new Punto2D(-3.0, 4.0);
        System.out.println(p7.dist(new Punto2D()));
        System.out.println(p7.dist(new Punto2D(2.5, 1.5)));

        Punto2D p8 = new Punto2D(-2.0, 3.0);
        Punto2D p9 = new Punto2D(2.0, 1.0);
        System.out.println(p8.manhattanDist(p9));
        System.out.println(p9.manhattanDist(p8));

        Punto2D p10 = new Punto2D(-2.0, 3.0);
        Punto2D p11 = new Punto2D(2.0, 1.0);
        System.out.println(p10.slope(p11));
        p10.setY(-1);
        System.out.println(p10.slope(p11));

    }

}
