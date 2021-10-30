package bai2;

import java.util.Scanner;

public class Array {
    private int[] a;
    private int n;
    public void inputData(){
        Scanner sc= new Scanner(System.in);
        System.out.println("Nhập số phần tử mảng: ");
        n = sc.nextInt();
        a = new int[n];
        for (int i=0; i<n; i++){
            a[i] = sc.nextInt();
        }
    }
    public void show(){
        for (int i=0; i<n; i++){
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
    public int sum(){
        int summ=0;
        for (int i=0; i<n; i++){
            summ+=a[i];
        }
        return summ;
    }
    public void filter(Boolean flag){
        if (flag){
            System.out.println("Cac so chan: ");
            for (int i=0; i<n; i++){
                if (a[i]%2==0){
                    System.out.print(a[i]+ " ");
                }
            }
        } else {
            System.out.println("Cac so le: ");
            for (int i=0; i<n; i++) {
                if (a[i] % 2 != 0) {
                    System.out.print(a[i] + " ");
                }
            }
        }
        System.out.println();
    }

    public Array() {
    }

    public Array(int[] a, int n) {
        this.a = a;
        this.n = n;
    }

    public int[] getA() {
        return a;
    }

    public void setA(int[] a) {
        this.a = a;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }
    public float tbc(){
        if (n!=0){
            return (float)sum()/n;
        } else return 0;
    }
}
