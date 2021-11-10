package bai_2;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Phieu {
    private String ma;
    private String ten;
    private DateTime a;
    private List <SanPham> x = new ArrayList<>();
    private int n;
    public void nhap(){
        Scanner sc =new Scanner(System.in);
        System.out.println("Nhap ma phieu: ");
        ma = sc.nextLine();
        System.out.println("Nhap ten phieu: ");
        ten = sc.nextLine();
        a =new DateTime();
        a.nhap();
        System.out.println("Nhap so loai san pham: ");
        n = sc.nextInt();

        for (int i=0; i<n; i++){
            System.out.println("Nhap loai san pham thu "+ (i+1));
            SanPham spp = new SanPham();
            spp.nhap();
            x.add(spp);
        }
    }
    public void xuat(){
        System.out.printf("Ma phieu: %s \t Ten phieu: %s\n", ma, ten);
        System.out.printf("Ngay nhap: ");  a.xuat();
        System.out.printf("%20s %20s %20s %20s %20s\n", "Ma sp", "Ten sp", "So luong", "Don gia", "Thanh tien");
        for (int i=0; i<n; i++){
            x.get(i).xuat();
        }
    }
}
