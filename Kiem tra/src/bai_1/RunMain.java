package bai_1;

import java.util.ArrayList;
import java.util.Scanner;

public class RunMain {
    public static void main(String[] args) {
        String str = new String();
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap chuoi : ");
        str = sc.nextLine();
        int count = 0, tich = 1, sum = 0;
        for (int i=0; i<str.length(); i++){
            if (str.charAt(i) >= 48 && str.charAt(i) <=57){
                count++;
                sum+=str.charAt(i)-48;
                tich *= (str.charAt(i)-48);
            }
        }
        System.out.println("Co "+ count + "ky tu so");
        System.out.println("Tich: "+ tich);

    }
}
