package bai_4;

import java.util.Scanner;

public class PhongMay {
    private String maPhong;
    private String tenPhong;
    private float dienTich;
    private QuanLy x = new QuanLy();
    private May[] y;
    private int n;
    public void nhap(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma phong: ");
        maPhong = sc.nextLine();
        System.out.print("Nhap ten phong: ");
        tenPhong = sc.nextLine();
        System.out.print("Nhap dien tich: ");
        dienTich = sc.nextFloat();
//        QuanLy x = new QuanLy();
        x.nhap();
        System.out.print("Nhap so loai may: ");
        n = sc.nextInt();
        y = new May[n];
        for (int i=0; i<n; i++){
            System.out.println("Nhap thong tin may thu "+(i+1)+ ": ");
            y[i] = new May();
            y[i].nhap();
        }
    }
    public void xuat(){
        System.out.printf("Ma phong: %s\n", maPhong);
        System.out.printf("Ten  phong: %s\n", tenPhong);
        System.out.printf("Dien tich: %f\n", dienTich);

        x.xuat();
        System.out.printf("%20s %20s %20s\n", "Ma may", "Kieu may", "Tinh trang");
        for (int i=0; i<n; i++){
            y[i].xuat();
        }
    }
}
