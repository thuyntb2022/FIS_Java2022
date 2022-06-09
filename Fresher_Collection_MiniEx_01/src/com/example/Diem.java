package com.example;

import java.io.Serializable;

public class Diem implements Comparable<Diem>, Serializable, Cloneable { // Serializable dung khi can lu tru object vao file
    private MonHoc mon;
    private int diem;

    public Diem(MonHoc mon, int diem) {
        this.mon = mon;
        this.diem = diem;
    }

    public boolean equals(Object that) {
        // Hai diem duoc goi la bang nhau neu cua cung mot mon
        if (that instanceof Diem) {
            return this.mon.equals(((Diem) that).mon);
        }
        return false;
    }

    @Override
    public int compareTo(Diem o) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int hashCode() {
        return mon.hashCode();
    }

    @Override
    public Diem clone() throws CloneNotSupportedException {
        return (Diem) super.clone();
    }

    @Override
    public String toString() {
        return "Diem{" +
                "mon=" + mon +
                ", diem=" + diem +
                '}';
    }

    public int getDiem() {
        return diem;
    }

    public void setDiem(int diem) {
        this.diem = diem;
    }

    public MonHoc getMon() {
        return mon;
    }

    public void setMon(MonHoc mon) {
        this.mon = mon;
    }
}
