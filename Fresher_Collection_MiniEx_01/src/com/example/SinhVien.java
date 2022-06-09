package com.example;

import java.util.*;

public class SinhVien implements Cloneable {
    private String mssv;
    private String ten;

    private Set<Diem> monDaHoc = new HashSet<Diem>();

    public SinhVien(String mssv, String ten) {
        this.mssv = mssv;
        this.ten = ten;
    }

    public boolean themDiem(Diem diemMoi) {
        return this.monDaHoc.add(diemMoi);
    }

    //TODO Cau 1
    public double tinhDiemTrungBinh() {
        double sum = 0;
        int soTinChi = 0;
        for (Diem d: monDaHoc) {
            sum += d.getDiem()*(d.getMon().getTcLT() + d.getMon().getTcTH());
            soTinChi += d.getMon().getTcLT() + d.getMon().getTcTH();
        }
        return Math.round(sum/soTinChi*10.0)/10.0;

    }


    //TODO Cau 2
    public String bangDiem() {
    /*
     MSSV : 0203044
     Ten  : Nguyen Van A
     Danh Sach Diem
     STT  Ten Mon             Diem       So Tin Chi
     1    Cau Truc Du Lieu 1  8          3
     2    Cau Truc Du Lieu 2  8          3
     Diem Trung Binh   8.0
    */
        StringBuilder str = new StringBuilder();
        str.append("MSSV : " + this.mssv + '\n' + "Ten  : " + this.ten + '\n' + "Danh Sach Diem" + '\n'+
                "STT  Ten Mon             Diem       So Tin Chi" + '\n');
        int i= 1;
        int soTC;
        for (Diem d: monDaHoc) {
            soTC = d.getMon().getTcLT() + d.getMon().getTcTH();
            str.append(i + "  ");
            str.append(d.getMon().getTen() + "   " + d.getDiem() + "   " + soTC +'\n');
            i++;
        }
        return str.toString();
    }


    //TODO Cau 3
    public String xepLoai() {
    /*
    Quy tac xep loai nhu sau
        DiemTB < 5 -> YEU
        DiemTB >= 5 va DiemTB < 6 -> TB
        DiemTB >= 6 va DiemTB < 7 -> TB-KHA
        DiemTB >= 7 va DiemTB < 8 -> KHA
        DiemTB >= 8 -> GIOI
    */
        if (this.tinhDiemTrungBinh() < 5 ) return "YEU";
        if (this.tinhDiemTrungBinh() >= 8 ) return "GIOI";
        if (this.tinhDiemTrungBinh() > 5 && this.tinhDiemTrungBinh() <6) return "TB";
         return "TB-KHA";

    }

    @Override
    public String toString() {
        return "SinhVien{" +
                "mssv='" + mssv + '\'' +
                ", ten='" + ten + '\'' +
                ", monDaHoc=" + monDaHoc +
                '}';
    }

    public String getMssv() {
        return mssv;
    }

    public void setMssv(String mssv) {
        this.mssv = mssv;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        SinhVien objClone = (SinhVien) super.clone();
        if (this.monDaHoc!=null) {
            this.monDaHoc.forEach(diem -> {
                try {
                    objClone.monDaHoc.add(diem.clone());
                } catch (CloneNotSupportedException e) {
                    e.printStackTrace();
                }
            });

        }
        return objClone;
    }
}
