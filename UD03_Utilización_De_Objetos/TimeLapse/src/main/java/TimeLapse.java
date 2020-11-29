/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Manuel
 */
public class TimeLapse {

    private int h;
    private int m;
    private int s;

    public TimeLapse() {
        this.h = 0;
        this.m = 0;
        this.s = 0;
    }

    public TimeLapse(int h, int m, int s) {
        this.h = h;
        this.m = m;
        this.s = s;
    }

    public TimeLapse(TimeLapse timeL) {
        this.h = timeL.h;
        this.m = timeL.m;
        this.s = timeL.s;
    }

    public TimeLapse(int s) {
        int horas = (s / 3600);
        int minutos = ((s - horas * 3600) / 60);
        int segundos = s - (horas * 3600 + minutos * 60);
        this.s = segundos;
        this.m = minutos;
        this.h = horas;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public int getM() {
        return m;
    }

    public void setM(int m) {
        this.m = m;
    }

    public int getS() {
        return s;
    }

    public void setS(int s) {
        this.s = s;
    }

    public int totalSec() {
        return this.h * 3600 + this.m * 60 + this.s;
    }
    
    public void reset(){
        this.h = 0;
        this.m = 0;
        this.s = 0;
    }
    
    public void addSec(long sec){
        sec += this.totalSec();
        long horas = (sec / 3600);
        long minutos = ((sec - horas * 3600) / 60);
        long segundos = sec - (horas * 3600 + minutos * 60);
        this.h = (int)horas;
        this.m = (int)minutos;
        this.s = (int)segundos;
    }
    
    public void addTime(TimeLapse t){
        addSec(t.totalSec());
    }
      
    public String toString() {
        return "TimeLapse["+ h + "h:" + m + "m:" + s + "s]";
    }
       
}
