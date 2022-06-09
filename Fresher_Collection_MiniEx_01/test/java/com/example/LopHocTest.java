package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LopHocTest {

    @Test
    void them() {

    }

    @Test
    void inDiem() {
        LopHoc lopHoc = new LopHoc("java_fresher", "Mr Vuong");
        SinhVien svt01 = new SinhVien("01","Le A");
        SinhVien svt02 = new SinhVien("01","Le B");
        svt01.themDiem(new Diem(new MonHoc(" Cau Truc Du Lieu 1",3,2),9));
        svt01.themDiem(new Diem(new MonHoc(" Cau Truc Du Lieu 2",2,2),8));
        svt02.themDiem(new Diem(new MonHoc(" Cau Truc Du Lieu 1",3,2),7));
        svt02.themDiem(new Diem(new MonHoc(" Cau Truc Du Lieu 2",2,2),8));
        lopHoc.them(svt01);
        lopHoc.them(svt02);
        System.out.println(lopHoc.inDiem());
    }

    @Test
    void top10() {
        LopHoc lopHoc = new LopHoc("java_fresher", "Mr Phuoc");
        SinhVien svt01 = new SinhVien("01","Le A");
        SinhVien svt02 = new SinhVien("01","Le B");
        SinhVien svt03 = new SinhVien("01","Le c");
        SinhVien svt04 = new SinhVien("01","Le D");
        SinhVien svt05 = new SinhVien("01","Le E");
        SinhVien svt06 = new SinhVien("01","Le G");
        SinhVien svt07 = new SinhVien("01","Le H");
        SinhVien svt08 = new SinhVien("01","Le I");
        SinhVien svt09 = new SinhVien("01","Le K");
        SinhVien svt10 = new SinhVien("01","Le M");
        SinhVien svt11 = new SinhVien("01","Le N");
        SinhVien svt12 = new SinhVien("01","Le LB");
        svt01.themDiem(new Diem(new MonHoc(" Cau Truc Du Lieu 1",3,2),9));
        svt02.themDiem(new Diem(new MonHoc(" Cau Truc Du Lieu 1",2,2),8));
        svt03.themDiem(new Diem(new MonHoc(" Cau Truc Du Lieu 1",3,2),7));
        svt04.themDiem(new Diem(new MonHoc(" Cau Truc Du Lieu 1",2,2),6));
        svt05.themDiem(new Diem(new MonHoc(" Cau Truc Du Lieu 1",3,2),9));
        svt06.themDiem(new Diem(new MonHoc(" Cau Truc Du Lieu 1",2,2),3));
        svt07.themDiem(new Diem(new MonHoc(" Cau Truc Du Lieu 1",3,2),7));
        svt08.themDiem(new Diem(new MonHoc(" Cau Truc Du Lieu 1",2,2),4));
        svt09.themDiem(new Diem(new MonHoc(" Cau Truc Du Lieu 1",3,2),5));
        svt10.themDiem(new Diem(new MonHoc(" Cau Truc Du Lieu 1",2,2),8));
        svt11.themDiem(new Diem(new MonHoc(" Cau Truc Du Lieu 1",3,2),7));
        svt12.themDiem(new Diem(new MonHoc(" Cau Truc Du Lieu 1",2,2),6));
        lopHoc.them(svt01);
        lopHoc.them(svt02);
        lopHoc.them(svt03);
        lopHoc.them(svt04);
        lopHoc.them(svt05);
        lopHoc.them(svt06);
        lopHoc.them(svt07);
        lopHoc.them(svt08);
        lopHoc.them(svt09);
        lopHoc.them(svt10);
        lopHoc.them(svt11);
        lopHoc.them(svt12);
        lopHoc.top10().stream().
                forEach(sv -> {System.out.print(sv.getTen() + "  "); System.out.println(sv.tinhDiemTrungBinh());});

    }

    @Test
    void sinhVienYeu() {
        LopHoc lopHoc = new LopHoc("java_fresher", "Mr Vuong");
        SinhVien svt01 = new SinhVien("01","Le A");
        SinhVien svt02 = new SinhVien("01","Le B");
        svt01.themDiem(new Diem(new MonHoc(" Cau Truc Du Lieu 1",3,2),9));
        svt01.themDiem(new Diem(new MonHoc(" Cau Truc Du Lieu 2",2,2),8));
        svt02.themDiem(new Diem(new MonHoc(" Cau Truc Du Lieu 1",3,2),3));
        svt02.themDiem(new Diem(new MonHoc(" Cau Truc Du Lieu 2",2,2),4));
        lopHoc.them(svt01);
        lopHoc.them(svt02);
        System.out.println(lopHoc.sinhVienYeu().toString());
    }

}