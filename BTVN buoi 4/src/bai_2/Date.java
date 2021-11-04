package bai_2;

import java.util.Scanner;

public class Date {
    private int d;
    private int m;
    private int y;

    public void nhap(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ngay : ");
        d = sc.nextInt();
        System.out.print("Nhap thang : ");
        m = sc.nextInt();
        System.out.print("Nhap nam : ");
        y = sc.nextInt();
    }
    public String xuat(){
        return d + "/" + m + "/" + y;
    }
}
