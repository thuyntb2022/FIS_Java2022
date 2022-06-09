package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SinhVienTest {

    @Test
    void tinhDiemTrungBinh() {
        SinhVien svt01 = new SinhVien("01","Le A");
        svt01.themDiem(new Diem(new MonHoc("CSDL",3,2),9));
        svt01.themDiem(new Diem(new MonHoc("GT",2,2),8));
        svt01.themDiem(new Diem(new MonHoc("CSDL",1,1),7));
        System.out.println(svt01.tinhDiemTrungBinh());
    }

    @Test
    void testToString() {
        SinhVien svt01 = new SinhVien("01","Le A");
        System.out.println(svt01.toString());


    }

    @Test
    void bangDiem() {
        SinhVien svt01 = new SinhVien("01","Le A");
        svt01.themDiem(new Diem(new MonHoc(" Cau Truc Du Lieu 1",3,2),9));
        svt01.themDiem(new Diem(new MonHoc(" Cau Truc Du Lieu 2",2,2),8));
        svt01.themDiem(new Diem(new MonHoc(" Cau Truc Du Lieu 3",1,1),7));
        System.out.println(svt01.bangDiem());

    }

    @Test
    void xepLoai() {
        SinhVien svt01 = new SinhVien("01","Le A");
        svt01.themDiem(new Diem(new MonHoc(" Cau Truc Du Lieu 1",3,2),9));
        svt01.themDiem(new Diem(new MonHoc(" Cau Truc Du Lieu 2",2,2),8));
        svt01.themDiem(new Diem(new MonHoc(" Cau Truc Du Lieu 3",1,1),7));
        System.out.println(svt01.xepLoai());

    }

}