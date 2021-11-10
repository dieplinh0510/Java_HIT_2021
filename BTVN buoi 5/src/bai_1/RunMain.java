package bai_1;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RunMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.println("Nhap danh sach diau hoa: ");
        n = sc.nextInt();
        List <DieuHoa> dieuHoas = new ArrayList<>();
        for (int i=0; i<n; i++){
            DieuHoa dh = new DieuHoa();
            dh.nhap();
            dieuHoas.add(dh);
        }
        System.out.printf("%20s %20s %20s %20s %20s %20s\n", "Ma SP", "Ten SP", "Ten Hang", "Ngay Nhap", "Cong Suat", "Gia Bán");
        for (int i=0; i<n; i++){
            dieuHoas.get(i).xuat();
        }
        System.out.println("San pham co ten hang la Electrolux: ");
        System.out.printf("%20s %20s %20s %20s %20s %20s\n", "Ma SP", "Ten SP", "Ten Hang", "Ngay Nhap", "Cong Suat", "Gia Bán");
        check(dieuHoas);

    }
    public static void check(List <DieuHoa> dieuHoas){
        DieuHoa dhh = dieuHoas.get(0);
        for (int i=0; i<dieuHoas.size(); i++){
            if (dieuHoas.get(i).getGiaban() < dhh.getGiaban()){
                dhh = dieuHoas.get(i);
            }
            if (dieuHoas.get(i).getTenHang().compareToIgnoreCase("Electrolux")==0){
                dieuHoas.get(i).xuat();
            }
        }
        System.out.println("San pham co gia ban thap nhat: ");
        dhh.xuat();
    }

}
