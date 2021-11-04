package bai_4;

import java.util.Scanner;

public class May {
    private String ma;
    private String kieu;
    private String tinhTrang;
    public void nhap(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma may: ");
        ma = sc.nextLine();
        System.out.print("Nhap kieu may: ");
        kieu = sc.nextLine();
        System.out.print("Nhap tinh trang: ");
        tinhTrang = sc.nextLine();
    }
    public void xuat(){
        System.out.printf("%20s %20s %20s", ma, kieu, tinhTrang);
    }
}
