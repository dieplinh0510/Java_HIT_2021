package bai_2;

import java.util.Scanner;

public class DateTime {
    private int ngay;
    private int thang;
    private int nam;
    public void nhap(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ngay : ");
        ngay = sc.nextInt();
        System.out.println("Nhap thang : ");
        thang = sc.nextInt();
        System.out.println("Nhap nam : ");
        nam = sc.nextInt();
    }
    public void xuat(){
        System.out.println(ngay+"/"+thang+"/"+nam);
    }
}
