package bai_3;

import java.util.Scanner;

public class SinhVien extends Nguoi{
    private String maSv;
    private String nganhHoc;
    private int khoaHoc;
    @Override
    public void nhap(){
        super.nhap();
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ma SV: ");
        setMaSv(sc.nextLine());
        System.out.println("Nhap nganh hoc: ");
        setNganhHoc(sc.nextLine());
        System.out.println("Nhap khoa hoc: ");
        setKhoaHoc(sc.nextInt());
    }
    @Override
    public void xuat(){
        super.xuat();
        System.out.printf("%20s %20s %20d\n", getMaSv(), getNganhHoc(), getKhoaHoc());
    }
    public SinhVien() {
    }

    public String getMaSv() {
        return maSv;
    }

    public void setMaSv(String maSv) {
        this.maSv = maSv;
    }

    public String getNganhHoc() {
        return nganhHoc;
    }

    public void setNganhHoc(String nganhHoc) {
        this.nganhHoc = nganhHoc;
    }

    public int getKhoaHoc() {
        return khoaHoc;
    }

    public void setKhoaHoc(int khoaHoc) {
        this.khoaHoc = khoaHoc;
    }
}
