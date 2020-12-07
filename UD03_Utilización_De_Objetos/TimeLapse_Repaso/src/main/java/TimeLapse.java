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
    
    private long h,m,s;
    
    public TimeLapse(){
        this.h = 0;
        this.m = 0;
        this.s = 0;
    }
    
    public TimeLapse(long h, long m, long s){
        this.h = h;
        this.m = m;
        this.s = s;
    }
    
    public TimeLapse(TimeLapse t){
        this.h = t.h;
        this.m = t.m;
        this.s = t.s;
    }
    
    public TimeLapse(long s){
        this.h = s/3600;
        this.m = (s-h*3600)/60;
        this.s = s-(h*3600+m*60);
    }

    public long getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public long getM() {
        return m;
    }

    public void setM(int m) {
        this.m = m;
    }

    public long getS() {
        return s;
    }

    public void setS(int s) {
        this.s = s;
    }
    
    public long totalSec(){
        return (h*3600)+(m*60)+s;
    }
    
    public void reset(){
        this.h = 0;
        this.m = 0;
        this.s = 0;
    }
    
    public void addSec(long sec){
        addTiempo(totalSec()+sec);
    }
    
    public void addTime(TimeLapse t){
        addTiempo(totalSec()+((t.h*3600)+(t.m*60)+t.s));
    }
    
    public void addTiempo(long s){
        this.h = s/3600;
        this.m = (s-h*3600)/60;
        this.s = s-(h*3600+m*60);
    }
    
    public String toString() {
        return "TimeLapse["+h+"h:"+m+"m:"+s+"s]";
    }
    
}
