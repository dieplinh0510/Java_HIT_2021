package bai3;

import java.util.Scanner;

public class RunMain {
    static Scanner sc = new Scanner(System.in);
    static String str;
    public static void main(String[] args) {
        System.out.println("Nhap mot chuoi: ");
        str = sc.nextLine();
        check();

    }

    public static void check(){
        int sum = 0, cnt = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= 48 && str.charAt(i) <= 57) {
                sum += str.charAt(i) - 48;
                cnt++;
            }
        }
        if (sum != 0){
            System.out.println(true);
            System.out.println("Trung binh cong cac chu so: " + (float)sum/cnt);
        }
        else System.out.println(false);
    }

}
