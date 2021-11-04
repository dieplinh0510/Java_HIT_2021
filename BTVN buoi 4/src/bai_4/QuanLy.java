package bai_4;

import java.util.Scanner;

public class QuanLy {
    private String ma;
    private String hoten;
    public void nhap(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma quan li: ");
        ma = sc.nextLine();
        System.out.print("Nhap ho ten: ");
        hoten = sc.nextLine();
    }
    public void xuat(){
        System.out.printf("Ma quan ly: %s\n", ma);
        System.out.printf("Ho ten: %s\n", hoten);
    }
}
