package model;

import java.util.ArrayList;
import java.util.List;

public class Bill {
    private int idBill;
    private int idUser;
    private List<Clothes> clothes = new ArrayList<>();
    private double discount;

    public Bill() {
    }

    public Bill(int idBill, int idUser, List<Clothes> clothes, double discount) {
        this.idBill = idBill;
        this.idUser = idUser;
        this.clothes = clothes;
        this.discount = discount;
    }

    public int getIdBill() {
        return idBill;
    }

    public void setIdBill(int idBill) {
        this.idBill = idBill;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public List<Clothes> getClothes() {
        return clothes;
    }

    public void setClothes(List<Clothes> clothes) {
        this.clothes = clothes;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "idBill=" + idBill +
                ", idUser=" + idUser +
                ", clothes=" + clothes +
                ", discount=" + discount +
                '}';
    }

    public void display(){
        System.out.println("\t\t\t\t\tId bill  : " + idBill);
        System.out.println("\t\t\t\t\tId user  : " + idUser);
        System.out.println("\t\t\t\t\tClothes  : " + clothes);
        System.out.println("\t\t\t\t\tDiscount : " + discount);
        System.out.println();
    }
}
