package bai_2;

import java.util.Scanner;

public class Person implements Comparable<Person>{
    private int id;
    private String name;
    private String address;

    public void nhap(){
        Scanner scanner = new Scanner(System.in);
        try{

            System.out.println("Nhap vao id: ");
            id = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Nhap name: ");
            name = scanner.nextLine();
            System.out.println("Nhap address: ");
            address = scanner.nextLine();
        } catch (Exception e){
            System.out.println("nhap khong dung");
        }

    }
    public Person() {
    }

    public Person(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    public int compareTo(Person o) {
        if (this.getName().compareToIgnoreCase(o.getName())==0){
            return  o.getAddress().compareTo(this.getAddress());
        }
        else {
            return this.getName().compareTo(o.getName());
        }
    }
}
