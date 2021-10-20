package bai2;

import java.util.Scanner;

public class RunMain {
    static Scanner sc = new Scanner(System.in);
    static int[] a = new int[1000];
    static int n = 0;


    public static void main(String[] args) {
        menu();
    }

    public static void menu(){
        int choose;
        do{
            System.out.println("----------------------Menu----------------------");
            System.out.println("1. Tạo và nhập mảng với n só nguyên.");
            System.out.println("2. Hiển thị mảng vừa tạo.");
            System.out.println("3. Thêm một phần tử vào vị trí k bất kỳ.");
            System.out.println("4. Xóa một phần tử tại vị trí k bất kỳ.");
            System.out.println("5. Đảo ngược mảng.");
            System.out.println("6. Hiển thị phần tử a[1] và các số chia hết cho a[1].");
            System.out.println("7. Xuất ra màn hình tổng các số nguyên tố có trong mảng.");
            System.out.println("8. Thoát.");
            System.out.println("-------------------------------------------------");
            System.out.print("Mời bạn lựa chọn: ");
            choose = sc.nextInt();
            switch (choose){
                case 1 :
                    input();
                    break;
                case 2:
                    output();
                    break;
                case 3:
                    insert();
                    break;
                case 4:
                    delete();
                    break;
                case 5:
                    reverse();
                    break;
                case 6:
                    showElement();
                    break;
                case 7:
                    showSum();
                    break;
                case 8:
                    System.out.println("Chương trình kết thúc");
                    break;
                default:
                    System.out.println("Lựa chọn không tồn tại!!!");
            }
        } while (choose != 8);
    }

    public  static  boolean isEmpty(){
        if (n == 0){
            System.out.println("Mang khong ton tai, moi nhap lua chon 1.");
            return true;
        }
        return false;
    }
    private static void input() {
        System.out.println("Nhap so phan tu cua mang: " );
        n = sc.nextInt();
        a = new int[n+1];
        for (int i = 0; i < n; i++){
            System.out.println("Nhap phan tu thu " + (i+1) + " : ");
            a[i] = sc.nextInt();
        }
    }

    private static void output() {
        if (!isEmpty()){
            System.out.print("Mang a: ");
            for (int i = 0; i < n; i++){
                System.out.print(a[i] + " ");
            }
        }
        System.out.println();
    }

    private static void insert() {
        if (!isEmpty()){
            System.out.println("Nhap  vi tri can chen: ");
            int k = sc.nextInt();
            System.out.println("Nhap phan tu can chen: ");
            int x = sc.nextInt();

            for (int i = n; i > k; i--){
                a[i] = a[i-1];
            }
            a[k-1] = x;
            n++;
            output();
        }

    }

    private static void delete() {

        if (!isEmpty()){
            System.out.println("Nhap vi tri can xoa: ");
            int k = sc.nextInt();
            for (int i = k - 1; i< n-1; i++){
                a[i] = a[i+1];
            }
            n--;
            output();
        }
    }

    private static void reverse() {

        if (!isEmpty()){
            for (int i = n-1; i >= 0; i--){
                System.out.print(a[i] + " ");
            }
            System.out.println();
        }
    }

    private static void showElement() {

        if (!isEmpty()){
            System.out.println("Phaan tu a[1] la : " + a[1]);
            System.out.print("Cac phan tu chia het cho a[1] : ");
            for (int i = 0; i < n; i++){
                if (a[i] % a[1] == 0){
                    System.out.print(a[i]+ " ");
                }
            }
            System.out.println();
        }
    }
    public static int check(int i){
        if (n < 2){
            return 0;
        }
        for (int j = 2; j <= Math.sqrt(n); j++){
            if (n % j == 0){
                return 0;
            }
        }
        return 1;
    }
    private static void showSum() {
        if (!isEmpty()){
            int sum = 0;
            for (int i = 0; i < n; i++){
                if (check(a[i]) == 1){
                    sum += a[i];
                }
            }
            System.out.println("Tong cac so nguyen to : " + sum);
        }
    }

}
