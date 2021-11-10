package bai_1;

import java.util.Scanner;

public class SanPham {
    private String maSP;
    private String tenSP;
    private String tenHang;
    private String ngayNhap;
    public void nhap(){
        Scanner sc =new Scanner(System.in);
        System.out.println("Nhap ma SP: ");
        maSP = sc.nextLine();
        System.out.println("Nhap ten SP: ");
        tenSP = sc.nextLine();
        System.out.println("Nhap ten hang: ");
        tenHang = sc.nextLine();
        System.out.println("Nhap ngay nhap: ");
        ngayNhap = sc.nextLine();
    }
    public void xuat(){
        System.out.printf("%20s %20s %20s %20s", maSP, tenSP, tenHang, ngayNhap);
    }

    public SanPham() {
    }

    public SanPham(String maSP, String tenSP, String tenHang, String ngayNhap) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.tenHang = tenHang;
        this.ngayNhap = ngayNhap;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getTenHang() {
        return tenHang;
    }

    public void setTenHang(String tenHang) {
        this.tenHang = tenHang;
    }

    public String getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(String ngayNhap) {
        this.ngayNhap = ngayNhap;
    }
}
