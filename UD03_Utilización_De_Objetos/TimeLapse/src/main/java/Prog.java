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

        

        TimeLapse t = new TimeLapse();
        System.out.println(t);

        TimeLapse t1 = new TimeLapse(3, 25, 42);
        System.out.println(t1);

        TimeLapse t2 = new TimeLapse(3, 25, 42);
        TimeLapse t3 = new TimeLapse(t2);
        System.out.println(t3);

        TimeLapse t4 = new TimeLapse(12930);
        System.out.println(t4);

        TimeLapse t5 = new TimeLapse();
        t5.setH(5);
        t5.setM(20);
        t5.setS(50);
        System.out.println(t5);

        TimeLapse t6 = new TimeLapse(5, 20, 50);
        System.out.println(t6.getH() + " " + t6.getM() + " " + t6.getS());

        TimeLapse t7 = new TimeLapse(5, 20, 50);
        System.out.println(t7.totalSec());

        TimeLapse t8 = new TimeLapse(5, 20, 50);
        t8.reset();
        System.out.println(t8);

        TimeLapse t9 = new TimeLapse(5, 50, 50);
        t9.addSec(10000);
        System.out.println(t9);

        TimeLapse t10 = new TimeLapse(5, 50, 50);
        t10.addTime(new TimeLapse(2, 46, 40));
        System.out.println(t10);

    }

}
