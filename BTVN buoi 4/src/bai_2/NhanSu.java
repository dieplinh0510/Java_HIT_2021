package bai_2;

import java.util.Scanner;

public class NhanSu {
    private String ma;
    private String hoTen;
    private Date ns;
    public void nhap(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma nhan su: ");
        ma = sc.nextLine();
        System.out.print("Nhap ho ten : ");
        hoTen = sc.nextLine();
        System.out.println("Nhap ngay nam sinh: ");
        ns = new Date();
        ns.nhap();
    }
    public void xuat(){
        System.out.printf("%20s %20s %20s\n", ma, hoTen, ns.xuat());
    }
}
