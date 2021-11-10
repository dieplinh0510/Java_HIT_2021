package bai_1;

import java.util.Scanner;

public class DieuHoa extends SanPham{
    private int congSuat;
    private int giaban;

    @Override
    public void nhap(){

        super.nhap();
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap cong suat: ");
        congSuat = sc.nextInt();
        System.out.println("Nhap gia ban: ");
        giaban = sc.nextInt();
    }


    @Override
    public void xuat(){
        super.xuat();
        System.out.printf("%20d %20d\n", congSuat, giaban);
    }

    public DieuHoa() {
    }

    public DieuHoa(int congSuat, int giaban) {
        this.congSuat = congSuat;
        this.giaban = giaban;
    }

    public DieuHoa(String maSP, String tenSP, String tenHang, String ngayNhap, int congSuat, int giaban) {
        super(maSP, tenSP, tenHang, ngayNhap);
        this.congSuat = congSuat;
        this.giaban = giaban;
    }

    public int getCongSuat() {
        return congSuat;
    }

    public void setCongSuat(int congSuat) {
        this.congSuat = congSuat;
    }

    public int getGiaban() {
        return giaban;
    }

    public void setGiaban(int giaban) {
        this.giaban = giaban;
    }


}
