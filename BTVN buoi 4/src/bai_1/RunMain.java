package bai_1;

import java.util.Scanner;

public class RunMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap n: ");
        int n = sc.nextInt();
        SACH[] sachs = new SACH[n];
        for (int i=0; i<n; i++){
            System.out.println("Nhap thong tin sach thu "+ (i+1) + " : ");
            sachs[i] = new SACH();
            sachs[i].nhap();
        }
        /*
        * %d: số nguyên
        * %f: số thực
        * %s: chuỗi
        * */
        System.out.printf("%20s %20s %20s %15s %15s\n", "Mã sách", "Tên sách", "NXB", "Số trang", "Giá tiền");
        for (int i=0; i<n; i++){
            sachs[i].xuat();
        }
    }
}
