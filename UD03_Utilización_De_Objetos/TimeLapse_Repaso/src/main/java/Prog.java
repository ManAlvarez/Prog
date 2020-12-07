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
        TimeLapse t = new TimeLapse();
        System.out.println(t);

        TimeLapse t1 = new TimeLapse(3, 25, 42);
        System.out.println(t1);

        TimeLapse t12 = new TimeLapse(3, 25, 42);
        TimeLapse t22 = new TimeLapse(t12);
        System.out.println(t22);

        TimeLapse t2 = new TimeLapse(12930);
        System.out.println(t2);

        TimeLapse t3 = new TimeLapse();
        t3.setH(5);
        t3.setM(20);
        t3.setS(50);
        System.out.println(t3);

        TimeLapse t4 = new TimeLapse(5, 20, 50);
        System.out.println(t4.getH() + " " + t4.getM() + " " + t4.getS());

        TimeLapse t5 = new TimeLapse(5, 20, 50);
        System.out.println(t5.totalSec());

        TimeLapse t6 = new TimeLapse(5, 20, 50);
        t6.reset();
        System.out.println(t6);

        TimeLapse t7 = new TimeLapse(5, 50, 50);
        t7.addSec(10000);
        System.out.println(t7);

        TimeLapse t8 = new TimeLapse(5, 50, 50);
        t8.addTime(new TimeLapse(2, 46, 40));
        System.out.println(t8);
    }

}
