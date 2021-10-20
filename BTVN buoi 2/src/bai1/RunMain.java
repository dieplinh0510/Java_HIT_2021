package bai1;

import java.util.Scanner;

public class RunMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap a: ");
        int a = sc.nextInt();
        System.out.print("Nhap b: ");
        int b = sc.nextInt();
        System.out.print("Nhap c: ");
        int c = sc.nextInt();

        System.out.println("Max = " + max(a, b, c));
    }

    public static int max(int a, int b, int c){
        return Math.max(a, Math.max(b, c));
    }
}
