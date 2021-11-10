package bai_2;

import java.util.Scanner;

public class SanPham {
    private String maSP;
    private String tenSp;
    private int soL;
    private float donGia;
    public void nhap(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ma SP: ");
        maSP = sc.nextLine();
        System.out.println("Nhap ten SP: ");
        tenSp = sc.nextLine();
        System.out.println("Nhap so luong SP: ");
        soL = sc.nextInt();
        System.out.println("Nhap ma SP: ");
        donGia = sc.nextFloat();
    }
    public void xuat(){
        System.out.printf("%20s %20s %20d %20f %20f", maSP, tenSp, soL, donGia, soL*donGia);
    }
}
