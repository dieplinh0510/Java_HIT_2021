package bai_2;

public class RunMain {
    public static void main(String[] args) {
        NhanSu x = new NhanSu();
        x.nhap();
        System.out.printf("%20s %20s %20s\n", "Ma nhan su", "Ho ten", "Ngay sinh");
        x.xuat();
    }
}
