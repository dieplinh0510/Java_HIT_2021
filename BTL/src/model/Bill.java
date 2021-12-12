package model;

import java.util.ArrayList;

public class Bill {
    private int idBill;
    private int idUser;
    private ArrayList <Clothes> clothes = new ArrayList<>();
    private double discount;

    public Bill() {
    }

    public Bill(int idBill, int idUser, ArrayList<Clothes> clothes, double discount) {
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

    public ArrayList<Clothes> getClothes() {
        return clothes;
    }

    public void setClothes(ArrayList<Clothes> clothes) {
        this.clothes = clothes;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
