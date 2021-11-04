package bai_1;

import java.util.Scanner;

public class SACH {
    private String maSach;
    private String tenSach;
    private String nxb;
    private int soTrang;
    private float giaTien;

    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma sach: ");
        maSach = sc.nextLine();
        System.out.print("Nhap ten sach: ");
        tenSach = sc.nextLine();
        System.out.print("Nhap nha xuat ban: ");
        nxb = sc.nextLine();
        System.out.print("Nhap so trang: ");
        soTrang = sc.nextInt();
        System.out.print("Nhap gia tien: ");
        giaTien = sc.nextFloat();
    }

    public void xuat(){
//        System.out.println(maSach +" "+ tenSach + " " + nXB + " " + soTrang + " " + giaTien);
        System.out.printf("%20s %20s %20s %15d %15f\n", maSach, tenSach, nxb, soTrang, giaTien);
    }


}
