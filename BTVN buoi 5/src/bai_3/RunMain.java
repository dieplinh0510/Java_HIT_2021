package bai_3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RunMain {
    public static void main(String[] args) {
        LopHoc lopHoc = new LopHoc();

        nhap(lopHoc);
        xuat(lopHoc);
        check(lopHoc);
        sort(lopHoc);
        xuat(lopHoc);

    }
    public static void nhap(LopHoc lopHoc){

        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ma LH: ");
        lopHoc.setMaLH(sc.nextLine());
        System.out.println("Nhap ten LH: ");
        lopHoc.setTenLH(sc.nextLine());
        System.out.println("Nhap ngay mo: ");
        lopHoc.setNgayMo(sc.nextLine());
        System.out.println("Nhap so sinh vien:");
        lopHoc.setN(sc.nextInt());

        List <SinhVien> sinhViens = new ArrayList<>();
        for (int i=0; i<lopHoc.getN(); i++){
            SinhVien sv = new SinhVien();
            sv.nhap();
            sinhViens.add(sv);
        }
        lopHoc.setSinhViens(sinhViens);
        System.out.println("Nhap giao vien: ");
        lopHoc.setGiaoVien(sc.nextLine());
    }
    public static void xuat(LopHoc lopHoc){
        System.out.printf("Ma LH: %s         Ten LH: %s\n", lopHoc.getMaLH(), lopHoc.getTenLH());
        System.out.printf("Ngay mo: %s           Giao vien: %s\n", lopHoc.getNgayMo(), lopHoc.getGiaoVien());
        System.out.printf("%20s %20s %20s ", "Ho ten", "Ngay sinh", "Que quan");
        System.out.printf("%20s %20s %20s\n", "Ma SV", "Ten SV", "Khoa hoc");
        for (int i=0; i<lopHoc.getN(); i++){
            lopHoc.getSinhViens().get(i).xuat();
        }
    }
    public static void check(LopHoc lopHoc){
        int cnt= 0;
        for (int i=0; i<lopHoc.getN(); i++){
            if (lopHoc.getSinhViens().get(i).getKhoaHoc()==15){
                cnt++;
            }
        }
        System.out.println("Co "+ cnt +" sinh vien khoa 15");
    }
    public static void sort(LopHoc lopHoc){
        for (int i=0; i<lopHoc.getN()-1; i++){
            for (int j=i+1; j<lopHoc.getN(); j++){
                if (lopHoc.getSinhViens().get(i).getKhoaHoc()>lopHoc.getSinhViens().get(j).getKhoaHoc()){
                    SinhVien temp = lopHoc.getSinhViens().get(i);
                    lopHoc.getSinhViens().set(i, lopHoc.getSinhViens().get(j));
                    lopHoc.getSinhViens().set(j, temp);
                }
            }
        }
    }
}
