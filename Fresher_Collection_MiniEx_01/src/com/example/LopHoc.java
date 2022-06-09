package com.example;

import java.util.*;

public class LopHoc implements Cloneable{
    private String ten;
    private String giaoVien;
    private List<SinhVien> dsLop = new ArrayList<SinhVien>();

    public LopHoc(String ten, String giaoVien) {
        this.ten = ten;
        this.giaoVien = giaoVien;
    }

    public boolean them(SinhVien svMoi) {
        return dsLop.add(svMoi);
    }

    //TODO Cau 4
    public String inDiem() {
    /*
    Danh Sach Diem Lop : ten
    Giao Vien Chu Nhiem : giaoVien
    STT      MSSV        Ten              Diem TB   XepLoai
    1        123456      Nguyen Van A     8.4       GIOI
    2        678919      Nguyen Van B     6         TB-KHA
    3        112456      Nguyen Van C     7         KHA
    */
        StringBuilder str = new StringBuilder();
        str.append("Danh Sach Diem Lop : " + ten + '\n');
        str.append("Giao Vien Chu Nhiem : " + giaoVien + '\n');
        str.append("STT  MSSV    Ten     Diem TB   XepLoai" + '\n');
        int i = 1;
        for (SinhVien sv: dsLop) {
            str.append(i + "    ");
            str.append(sv.getMssv() + "   " + sv.getTen() + "   " + sv.tinhDiemTrungBinh() + "   " +
                    sv.xepLoai() + '\n');
            i++;
        }
        return str.toString();
    }

    //TODO Cau 5
    public List<SinhVien> top10() {
        //Tra ve danh sach 10 sinh vien co diem trung binh lon nhat lop
       // e chua thuc hanh duoc deep copy ^^
        List <SinhVien> lst = new ArrayList<>();
        dsLop.forEach(sv -> {
            try {
                lst.add((SinhVien) sv.clone());
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        });
        dsLop.sort((sv1, sv2) -> (int) (sv1.tinhDiemTrungBinh() - sv2.tinhDiemTrungBinh()) * 10);
        return dsLop.subList(dsLop.size()-10, dsLop.size());


    }

    //TODO Cau 6
    public List<SinhVien> sinhVienYeu() {
        //Tra ve danh sach vien vien xep loai YEU
        return dsLop.stream().filter(sv -> sv.xepLoai().equals("YEU")).toList();
    }

}
