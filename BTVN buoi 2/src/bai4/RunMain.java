package bai4;

import java.util.Scanner;

public class RunMain {
    static Scanner sc = new Scanner(System.in);
    static String str;
    public static void main(String[] args) {
        System.out.println("Nhap 1 chuoi bat ki : ");
        str = sc.nextLine();

        while (str.indexOf("  ") != -1){
            str = str.replaceAll("  ", " ");
        }
        str = str.trim();
        String a[] = str.split(" ");
        String s = "";
        for (int i = 0; i < a.length; i++){
            String b = String.valueOf(a[i].charAt(0)).toUpperCase();
            s += b + a[i].substring(1);
            if (i < a.length - 1){
                s+=" ";
            }
        }
        System.out.println(s);
    }


}
