package bai_2;

import java.util.ArrayList;
import java.util.Scanner;

public class RunMain {
    public static void main(String[] args) {
        ArrayList <Book> books = new ArrayList<>();
        Book book = new Book();
        nhap(book);
        Menu(books);

    }
    public static void nhap(Book book){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap id: ");
        book.id = sc.nextLine();
        System.out.println("Nhap name: ");
        book.name = sc.nextLine();
        System.out.println("Nhap publisher: ");
        book.publisher = sc.nextLine();
        System.out.println("Nhap price: ");
        book.price = sc.nextFloat();
        System.out.println("Nhap numberofpage: ");
        book.setNumberOfPage(sc.nextInt()) ;
        System.out.println("Nhap author: ");
        book.setAuthor(sc.nextLine());

    }
    public static void Menu(ArrayList <Book> books ){
        int x ;
        Scanner sc= new Scanner(System.in);
        System.out.println("Nhap x: ");
        x = sc.nextInt();
        switch (x){
            case 1:
                System.out.println("add them 1 book vao danh sach: ");
                addBook(books);
                break;
            case 2:
                System.out.println("Chon edit 1 thuoc tinh cua book theo id: ");
                editBookById(books);
                break;
            case 3:
                System.out.println("xoa 1 book khoi danh sach");
                deleteBookById(books);
                break;
            case 4:
                System.out.println("sap xep sach theo ten: ");
                sortBookByName(books);
                break;
            case 5:
                System.out.println("sap xep theo gia giam dan: ");
                sortBookByPrice(books);
                break;
            case 6:
                System.out.println("danh sach book co trong thu vien: ");
                for (int i=0; i<books.size(); i++){
                    show(books.get(i));
                }

                break;
            case 7:
                System.out.println("Thoat chuong trinh: ");
                break;
            default:
                System.out.println("case khong dung, xin nhap lai");
                break;
        }
    }

    private static void show(Book  book) {
        System.out.printf("%20s %20s %20s %20f %20d %20s", book.id,book.name, book.publisher, book.price, book.getNumberOfPage(), book.getAuthor());
    }

    private static void sortBookByPrice(ArrayList <Book> books) {
        for (int i=0; i<books.size(); i++){
            for (int j= i+1; j< books.size(); j++){
                if (books.get(i).price> books.get(j).price){
                    Book temp = books.get(i);
                    books.set(i, books.get(j));
                    books.set(j, temp);
                }
            }
        }
    }

    private static void sortBookByName(ArrayList <Book> books) {
        
    }

    private static void deleteBookById(ArrayList <Book> books) {
        for (int i=0; i<books.size(); i++){
            if (books.get(i).id.equals("lamlinh") ){
                books.remove(i);
            }
        }
    }

    private static void editBookById(ArrayList <Book> books ) {
        for (int i=0; i<books.size(); i++){
            if (books.get(i).id.equals("lamlinh") ){
                books.get(i).id = "LamLinh";
            }
        }
    }

    private static void addBook(ArrayList <Book> books ) {
        Book book = new Book();
        nhap(book);
        books.add(book);
    }
}
