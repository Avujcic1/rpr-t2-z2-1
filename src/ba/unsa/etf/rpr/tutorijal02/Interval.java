package ba.unsa.etf.rpr.tutorijal02;

public class Interval {
    private double pt;
    private double kt;
    private boolean pt1;
    private boolean kt1;

    Interval(double pt, double kt, boolean pt1, boolean kt1) throws IllegalArgumentException {
        if(pt > kt) throw new IllegalArgumentException();
        this.pt = pt;
        this.kt = kt;
        this.pt1 = pt1;
        this.kt1 = kt1;
    }

    Interval() {
        this.pt = 0;
        this.kt = 0;
        this.pt1 = false;
        this.kt1 = false;
    }

    public static Interval intersect(Interval i1, Interval i2) {
        Interval interval = new Interval();
        if (i1.pt > i2.pt) {
            interval.pt = i1.pt;
            if (i1.pt1) interval.pt1 = true;
        } else {
            interval.pt = i2.pt;
            if (i2.pt1) interval.pt1 = true;
        }
        if (i1.kt < i2.kt) {
            interval.kt = i1.kt;
            if (i1.kt1) interval.kt1 = true;
        } else {
            interval.kt = i2.kt;
            if (i2.kt1) interval.kt1 = true;
        }
        return interval;
    }

    @Override
    public String toString(){
        String s = "";
        if(this.pt == 0 && this.kt == 0) {
            s += "()";
            return s;
        } else {
            if(pt1) s += "[";
            else s += "(";
            s += pt;
            s += ",";
            s += kt;
            if(kt1) s += "]";
            else s += ")";
        }
        return s;
    }

    @Override
    public boolean equals(Object object) {
        if(this == object) return true;
        if(object == null) return false;

        Interval interval = (Interval) object;
        if(interval.pt != this.pt) return false;
        if(interval.kt != this.kt) return false;
        if(interval.pt1 != this.pt1) return false;
        if(interval.kt1 != this.kt1) return false;

        return true;
    }




    public boolean isIn(double v) {
        if (v < pt || v > kt) return false;
        if (v > pt && v < kt) return true;
        if (pt1 && v == pt || kt1 && v == kt) return true;
        else return false;
    }

    public boolean isNull() {
        if (this.pt1 == false && this.kt1 == false && this.pt == 0 && this.kt == 0)
            return true;
        else return false;
    }

    public Interval intersect(Interval i) {
        Interval interval = new Interval();
        if (i.pt > this.pt) {
            interval.pt = i.pt;
            if (i.pt1) interval.pt1 = true;
        } else {
            interval.pt = this.pt;
            if (this.pt1) interval.pt1 = true;
        }
        if (i.kt < this.kt) {
            interval.kt = i.kt;
            if (i.kt1) interval.kt1 = true;
        } else {
            interval.kt = this.kt;
            if (this.kt1) interval.kt1 = true;
        }
        return interval;
    }
}