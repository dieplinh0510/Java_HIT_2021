package model;

import java.util.ArrayList;

public class ClotherStore {
    private ArrayList<Clothes> clothes = new ArrayList<>();

    public ClotherStore() {
    }

    public ClotherStore(ArrayList<Clothes> clothes) {
        this.clothes = clothes;
    }

    public ArrayList<Clothes> getClothes() {
        return clothes;
    }

    public void setClothes(ArrayList<Clothes> clothes) {
        this.clothes = clothes;
    }
}
